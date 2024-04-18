package com.xc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.xc.common.ServerResponse;
import com.xc.dao.*;
import com.xc.pojo.*;
import com.xc.service.*;
import com.xc.utils.DateTimeUtil;
import com.xc.utils.KeyUtils;
import com.xc.utils.stock.BuyAndSellUtils;
import com.xc.utils.stock.GeneratePosition;
import com.xc.utils.stock.GetStayDays;
import com.xc.utils.stock.sina.SinaStockApi;
import com.xc.vo.agent.AgentIncomeVO;
import com.xc.vo.position.*;
import com.xc.vo.stock.StockListVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service("iUserPositionService")
public class UserPositionServiceImpl implements IUserPositionService {
    private static Logger log = LoggerFactory.getLogger(UserPositionServiceImpl.class);
    @Autowired
    private UserPositionMapper userPositionMapper;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private ISiteSettingService iSiteSettingService;
    @Autowired

    private ISiteSpreadService iSiteSpreadService;
    @Autowired
    private IStockService iStockService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserCashDetailMapper userCashDetailMapper;
    @Autowired
    private IAgentUserService iAgentUserService;
    @Autowired
    private AgentUserMapper agentUserMapper;
    @Autowired
    private SiteTaskLogMapper siteTaskLogMapper;
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private AgentAgencyFeeMapper agentAgencyFeeMapper;
    @Autowired
    private IAgentAgencyFeeService iAgentAgencyFeeService;
    @Autowired
    private ISiteProductService iSiteProductService;
    @Autowired
    private FundsApplyMapper fundsApplyMapper;


    @Override
    public ServerResponse buy(Integer stockId, Integer buyNum, Integer buyType, Integer lever, HttpServletRequest request) throws Exception {


        SiteProduct siteProduct = iSiteProductService.getProductSetting();
        User user = this.iUserService.getCurrentRefreshUser(request);
        if ((siteProduct.getRealNameDisplay().booleanValue()) && ((StringUtils.isBlank(user.getRealName())) || (StringUtils.isBlank(user.getIdCard())))) {
            return ServerResponse.createByErrorMsg("下单失败，请先实名认证");
        }
        BigDecimal user_enable_amt = user.getEnableAmt();
        log.info("用户 {} 下单，股票id = {} ，数量 = {} , 方向 = {} , 杠杆 = {}", new Object[]{user
                .getId(), stockId, buyNum, buyType, lever});
        if ((siteProduct.getRealNameDisplay().booleanValue()) && (user.getIsLock().intValue() == 1)) {
            return ServerResponse.createByErrorMsg("下单失败，账户已被锁定");
        }
        if (siteProduct.getHolidayDisplay().booleanValue()) {
            return ServerResponse.createByErrorMsg("周末或节假日不能交易！");
        }
        SiteSetting siteSetting = this.iSiteSettingService.getSiteSetting();
        if (siteSetting == null) {
            log.error("下单出错，网站设置表不存在");
            return ServerResponse.createByErrorMsg("下单失败，系统设置错误");
        }
        String am_begin = siteSetting.getTransAmBegin();
        String am_end = siteSetting.getTransAmEnd();
        String pm_begin = siteSetting.getTransPmBegin();
        String pm_end = siteSetting.getTransPmEnd();
        boolean am_flag = BuyAndSellUtils.isTransTime(am_begin, am_end);
        boolean pm_flag = BuyAndSellUtils.isTransTime(pm_begin, pm_end);
        log.info("是否在上午交易时间 = {} 是否在下午交易时间 = {}", Boolean.valueOf(am_flag), Boolean.valueOf(pm_flag));
        if ((!am_flag) && (!pm_flag)) {
            return ServerResponse.createByErrorMsg("下单失败，不在交易时段内");
        }
        Stock stock = null;
        ServerResponse stock_res = this.iStockService.findStockById(stockId);
        if (!stock_res.isSuccess()) {
            return ServerResponse.createByErrorMsg("下单失败，股票代码错误");
        }
        stock = (Stock) stock_res.getData();
        if (stock.getIsLock().intValue() != 0) {
            return ServerResponse.createByErrorMsg("下单失败，当前股票不能交易");
        }
        List dbPosition = findPositionByStockCodeAndTimes(siteSetting.getBuySameTimes().intValue(), stock
                .getStockCode(), user.getId());
        if (dbPosition.size() >= siteSetting.getBuySameNums().intValue()) {
            return ServerResponse.createByErrorMsg("频繁交易," + siteSetting.getBuySameTimes() + "分钟内同一股票持仓不得超过" + siteSetting
                    .getBuySameNums() + "条");
        }
        Integer transNum = findPositionNumByTimes(siteSetting.getBuyNumTimes().intValue(), user.getId());
        if (transNum.intValue() / 100 >= siteSetting.getBuyNumLots().intValue()) {
            return ServerResponse.createByErrorMsg("频繁交易," + siteSetting
                    .getBuyNumTimes() + "分钟内不能超过" + siteSetting.getBuyNumLots() + "手");
        }
        if (buyNum.intValue() < siteSetting.getBuyMinNum().intValue()) {
            return ServerResponse.createByErrorMsg("下单失败，购买数量小于" + siteSetting
                    .getBuyMinNum() + "股");
        }
        if (buyNum.intValue() > siteSetting.getBuyMaxNum().intValue()) {
            return ServerResponse.createByErrorMsg("下单失败，购买数量大于" + siteSetting
                    .getBuyMaxNum() + "股");
        }
        StockListVO stockListVO = SinaStockApi.assembleStockListVO(SinaStockApi.getSinaStock(stock.getStockGid()));
        BigDecimal now_price = new BigDecimal(stockListVO.getNowPrice());
        if (now_price.compareTo(new BigDecimal("0")) == 0) {
            return ServerResponse.createByErrorMsg("报价0，请稍后再试");
        }
        double stock_crease = stockListVO.getHcrate().doubleValue();


        BigDecimal maxRisePercent = new BigDecimal("0");
        if (stock.getStockPlate() != null) {
            maxRisePercent = new BigDecimal("0.2");
            log.info("【科创股票】");
        } else {
            maxRisePercent = new BigDecimal("0.1");
            log.info("【普通A股】");
        }
        if ((stockListVO.getName().startsWith("ST")) || (stockListVO.getName().endsWith("退"))) {
            return ServerResponse.createByErrorMsg("ST和已退市的股票不能入仓");
        }
        BigDecimal zsPrice = new BigDecimal(stockListVO.getPreclose_px());

        BigDecimal ztPrice = zsPrice.multiply(maxRisePercent).add(zsPrice);
        ztPrice = ztPrice.setScale(2, 4);
        BigDecimal chaPrice = ztPrice.subtract(zsPrice);

        BigDecimal ztRate = chaPrice.multiply(new BigDecimal("100")).divide(zsPrice, 2, 4);

        log.info("当前涨跌幅 = {} % , 涨停幅度 = {} %", Double.valueOf(stock_crease), ztRate);
        if ((new BigDecimal(String.valueOf(stock_crease)).compareTo(ztRate) == 0) &&
                (buyType.intValue() == 0)) {
            return ServerResponse.createByErrorMsg("当前股票已涨停不能买涨");
        }
        if ((stock.getStockPlate() == null) || (StringUtils.isEmpty(stock.getStockPlate()))) {
            int maxcrease = siteSetting.getCreaseMaxPercent().intValue();
            if ((stock_crease > 0.0D) && (stock_crease >= maxcrease)) {
                return ServerResponse.createByErrorMsg("下单失败，股票当前涨幅:" + stock_crease + ",大于最大涨幅:" + maxcrease);
            }
            if ((stock_crease < 0.0D) && (-stock_crease > maxcrease)) {
                return ServerResponse.createByErrorMsg("下单失败，股票当前跌幅:" + stock_crease + ",大于最大跌幅:" + maxcrease);
            }
        } else if ("创业".equals(stock.getStockPlate())) {
            int maxcrease = siteSetting.getCyCreaseMaxPercent().intValue();
            if ((stock_crease > 0.0D) && (stock_crease >= maxcrease)) {
                return ServerResponse.createByErrorMsg("下单失败，创业股当前涨幅:" + stock_crease + ",大于最大涨幅:" + maxcrease);
            }
            if ((stock_crease < 0.0D) && (-stock_crease > maxcrease)) {
                return ServerResponse.createByErrorMsg("下单失败，创业股当前跌幅:" + stock_crease + ",大于最大跌幅:" + maxcrease);
            }
        } else {
            int maxcrease = siteSetting.getKcCreaseMaxPercent().intValue();
            if ((stock_crease > 0.0D) && (stock_crease >= maxcrease)) {
                return ServerResponse.createByErrorMsg("下单失败，科创股当前涨幅:" + stock_crease + ",大于最大涨幅:" + maxcrease);
            }
            if ((stock_crease < 0.0D) && (-stock_crease > maxcrease)) {
                return ServerResponse.createByErrorMsg("下单失败，科创股当前跌幅:" + stock_crease + ",大于最大跌幅:" + maxcrease);
            }
        }
        ServerResponse serverResponse = this.iStockService.selectRateByDaysAndStockCode(stock
                .getStockCode(), siteSetting.getStockDays().intValue());
        if (!serverResponse.isSuccess()) {
            return serverResponse;
        }
        BigDecimal daysRate = (BigDecimal) serverResponse.getData();
        log.info("股票 {} ， {} 天内 涨幅 {} , 设置的涨幅 = {}", new Object[]{stock.getStockCode(), siteSetting
                .getStockDays(), daysRate, siteSetting.getStockRate()});
        if ((daysRate != null) &&
                (siteSetting.getStockRate().compareTo(daysRate) == -1)) {
            return ServerResponse.createByErrorMsg(siteSetting.getStockDays() + "天内涨幅超过 " + siteSetting
                    .getStockRate() + "不能交易");
        }
        BigDecimal buy_amt = now_price.multiply(new BigDecimal(buyNum.intValue()));


        BigDecimal buy_amt_autual = buy_amt.divide(new BigDecimal(lever.intValue()), 2, 4);


        int compareInt = buy_amt_autual.compareTo(new BigDecimal(siteSetting.getBuyMinAmt().intValue()));
        if (compareInt == -1) {
            return ServerResponse.createByErrorMsg("下单失败，购买金额小于" + siteSetting
                    .getBuyMinAmt() + "元");
        }
        BigDecimal max_buy_amt = user_enable_amt.multiply(siteSetting.getBuyMaxAmtPercent());
        int compareCwInt = buy_amt_autual.compareTo(max_buy_amt);
        if (compareCwInt == 1) {
            return ServerResponse.createByErrorMsg("下单失败，不能超过可用资金的" + siteSetting
                    .getBuyMaxAmtPercent().multiply(new BigDecimal("100")) + "%");
        }
        int compareUserAmtInt = user_enable_amt.compareTo(buy_amt_autual);
        log.info("用户可用金额 = {}  实际购买金额 =  {}", user_enable_amt, buy_amt_autual);
        log.info("比较 用户金额 和 实际 购买金额 =  {}", Integer.valueOf(compareUserAmtInt));
        if (compareUserAmtInt == -1) {
            return ServerResponse.createByErrorMsg("下单失败，融资可用金额小于" + buy_amt_autual + "元");
        }
        if (user.getUserIndexAmt().compareTo(new BigDecimal("0")) == -1) {
            return ServerResponse.createByErrorMsg("失败，指数总资金小于0");
        }
        if (user.getUserFutAmt().compareTo(new BigDecimal("0")) == -1) {
            return ServerResponse.createByErrorMsg("失败，期货总资金小于0");
        }
        UserPosition userPosition = new UserPosition();
        userPosition.setPositionType(user.getAccountType());
        userPosition.setPositionSn(KeyUtils.getUniqueKey());
        userPosition.setUserId(user.getId());
        userPosition.setNickName(user.getRealName());
        userPosition.setAgentId(user.getAgentId());
        userPosition.setStockCode(stock.getStockCode());
        userPosition.setStockName(stock.getStockName());
        userPosition.setStockGid(stock.getStockGid());
        userPosition.setStockSpell(stock.getStockSpell());
        userPosition.setBuyOrderId(GeneratePosition.getPositionId());
        userPosition.setBuyOrderTime(new Date());
        userPosition.setBuyOrderPrice(now_price);
        userPosition.setOrderDirection(buyType.intValue() == 0 ? "买涨" : "买跌");

        userPosition.setOrderNum(buyNum);
        if (stock.getStockPlate() != null) {
            userPosition.setStockPlate(stock.getStockPlate());
        }
        userPosition.setIsLock(Integer.valueOf(0));


        userPosition.setOrderLever(lever);


        userPosition.setOrderTotalPrice(buy_amt);


        BigDecimal stayFee = userPosition.getOrderTotalPrice().multiply(siteSetting.getStayFee());
        BigDecimal allStayFee = stayFee.multiply(new BigDecimal(1));
        userPosition.setOrderStayFee(allStayFee);
        userPosition.setOrderStayDays(Integer.valueOf(1));


        BigDecimal buy_fee_amt = buy_amt.multiply(siteSetting.getBuyFee()).setScale(2, 4);
        log.info("用户购买手续费（配资后总资金 * 百分比） = {}", buy_fee_amt);
        userPosition.setOrderFee(buy_fee_amt);


        BigDecimal buy_yhs_amt = buy_amt.multiply(siteSetting.getDutyFee()).setScale(2, 4);
        log.info("用户购买印花税（配资后总资金 * 百分比） = {}", buy_yhs_amt);
        userPosition.setOrderSpread(buy_yhs_amt);

        SiteSpread siteSpread = this.iSiteSpreadService.findSpreadRateOne(new BigDecimal(stock_crease), buy_amt, stock.getStockCode(), now_price);
        BigDecimal spread_rate_amt = new BigDecimal("0");
        if (siteSpread != null) {
            spread_rate_amt = buy_amt.multiply(siteSpread.getSpreadRate()).setScale(2, 4);
            log.info("用户购买点差费（配资后总资金 * 百分比{}） = {}", siteSpread.getSpreadRate(), spread_rate_amt);
        } else {
            log.info("用户购买点差费（配资后总资金 * 百分比{}） = {}", "设置异常", spread_rate_amt);
        }
        userPosition.setSpreadRatePrice(spread_rate_amt);


        BigDecimal profit_and_lose = new BigDecimal("0");
        userPosition.setProfitAndLose(profit_and_lose);


        BigDecimal all_profit_and_lose = profit_and_lose.subtract(buy_fee_amt).subtract(buy_yhs_amt).subtract(spread_rate_amt);
        userPosition.setAllProfitAndLose(all_profit_and_lose);


        userPosition.setOrderStayDays(Integer.valueOf(0));
        userPosition.setOrderStayFee(new BigDecimal("0"));

        int insertPositionCount = 0;
        this.userPositionMapper.insert(userPosition);
        insertPositionCount = userPosition.getId().intValue();
        if (insertPositionCount > 0) {
            BigDecimal reckon_enable = user_enable_amt.subtract(buy_amt_autual);
            user.setEnableAmt(reckon_enable);
            int updateUserCount = this.userMapper.updateByPrimaryKeySelective(user);
            if (updateUserCount > 0) {
                log.info("【用户交易下单】修改用户金额成功");
            } else {
                log.error("用户交易下单】修改用户金额出错");
                throw new Exception("用户交易下单】修改用户金额出错");
            }
            this.iAgentAgencyFeeService.AgencyFeeIncome(1, userPosition.getPositionSn());
            log.info("【用户交易下单】保存持仓记录成功");
        } else {
            log.error("用户交易下单】保存持仓记录出错");
            throw new Exception("用户交易下单】保存持仓记录出错");
        }
        return ServerResponse.createBySuccess("下单成功");

    }


    public ServerResponse sell(String positionSn, int doType)
            throws Exception {
        log.info("【用户交易平仓】 positionSn = {} ， dotype = {}", positionSn, Integer.valueOf(doType));

        SiteSetting siteSetting = this.iSiteSettingService.getSiteSetting();
        if (siteSetting == null) {
            log.error("平仓出错，网站设置表不存在");
            return ServerResponse.createByErrorMsg("下单失败，系统设置错误");
        }
        SiteProduct siteProduct = this.iSiteProductService.getProductSetting();
        if (doType != 0) {
            String am_begin = siteSetting.getTransAmBegin();
            String am_end = siteSetting.getTransAmEnd();
            String pm_begin = siteSetting.getTransPmBegin();
            String pm_end = siteSetting.getTransPmEnd();
            boolean am_flag = BuyAndSellUtils.isTransTime(am_begin, am_end);
            boolean pm_flag = BuyAndSellUtils.isTransTime(pm_begin, pm_end);
            log.info("是否在上午交易时间 = {} 是否在下午交易时间 = {}", Boolean.valueOf(am_flag), Boolean.valueOf(pm_flag));
            if ((!am_flag) && (!pm_flag)) {
                return ServerResponse.createByErrorMsg("平仓失败，不在交易时段内");
            }
            if (siteProduct.getHolidayDisplay().booleanValue()) {
                return ServerResponse.createByErrorMsg("周末或节假日不能交易！");
            }
        }
        UserPosition userPosition = this.userPositionMapper.findPositionBySn(positionSn);
        if (userPosition == null) {
            return ServerResponse.createByErrorMsg("平仓失败，订单不存在");
        }
        User user = this.userMapper.selectByPrimaryKey(userPosition.getUserId());
        if ((siteProduct.getRealNameDisplay().booleanValue()) && (user.getIsLock().intValue() == 1)) {
            return ServerResponse.createByErrorMsg("平仓失败，用户已被锁定");
        }
        if (userPosition.getSellOrderId() != null) {
            return ServerResponse.createByErrorMsg("平仓失败，此订单已平仓");
        }
        if (1 == userPosition.getIsLock().intValue()) {
            return ServerResponse.createByErrorMsg("平仓失败 " + userPosition.getLockMsg());
        }
        if (!DateTimeUtil.isCanSell(userPosition.getBuyOrderTime(), siteSetting.getCantSellTimes().intValue())) {
            return ServerResponse.createByErrorMsg(siteSetting.getCantSellTimes() + "分钟内不能平仓");
        }
        if (DateTimeUtil.sameDate(DateTimeUtil.getCurrentDate(), userPosition.getBuyOrderTime())) {
            return ServerResponse.createByErrorMsg("当天入仓的股票需要隔天才能出仓");
        }
        StockListVO stockListVO = SinaStockApi.assembleStockListVO(SinaStockApi.getSinaStock(userPosition.getStockGid()));

        BigDecimal now_price = new BigDecimal(stockListVO.getNowPrice());
        if (now_price.compareTo(new BigDecimal("0")) != 1) {
            log.error("股票 = {} 收到报价 = {}", userPosition.getStockName(), now_price);
            return ServerResponse.createByErrorMsg("报价0，平仓失败，请稍后再试");
        }
        double stock_crease = stockListVO.getHcrate().doubleValue();

        BigDecimal zsPrice = new BigDecimal(stockListVO.getPreclose_px());

        BigDecimal ztPrice = zsPrice.multiply(new BigDecimal("0.1")).add(zsPrice);
        ztPrice = ztPrice.setScale(2, 4);
        BigDecimal chaPrice = ztPrice.subtract(zsPrice);

        BigDecimal ztRate = chaPrice.multiply(new BigDecimal("100")).divide(zsPrice, 2, 4);

        ztRate = ztRate.negate();
        log.info("股票当前涨跌幅 = {} 跌停幅度 = {}", Double.valueOf(stock_crease), ztRate);
        if ((new BigDecimal(String.valueOf(stock_crease)).compareTo(ztRate) == 0) &&
                ("买涨".equals(userPosition.getOrderDirection()))) {
            return ServerResponse.createByErrorMsg("当前股票已跌停不能卖出");
        }
        Integer buy_num = userPosition.getOrderNum();

        BigDecimal all_buy_amt = userPosition.getOrderTotalPrice();

        BigDecimal all_sell_amt = now_price.multiply(new BigDecimal(buy_num.intValue()));

        BigDecimal profitLoss = new BigDecimal("0");
        if ("买涨".equals(userPosition.getOrderDirection())) {
            log.info("买卖方向：{}", "涨");

            profitLoss = all_sell_amt.subtract(all_buy_amt);
        } else {
            log.info("买卖方向：{}", "跌");
            profitLoss = all_buy_amt.subtract(all_sell_amt);
        }
        log.info("买入总金额 = {} , 卖出总金额 = {} , 盈亏 = {}", new Object[]{all_buy_amt, all_sell_amt, profitLoss});

        BigDecimal user_all_amt = user.getUserAmt();
        BigDecimal user_enable_amt = user.getEnableAmt();
        log.info("用户原本总资金 = {} , 可用 = {}", user_all_amt, user_enable_amt);

        BigDecimal buy_fee_amt = userPosition.getOrderFee();
        log.info("买入手续费 = {}", buy_fee_amt);

        BigDecimal orderSpread = userPosition.getOrderSpread();
        log.info("印花税 = {}", orderSpread);

        BigDecimal orderStayFee = userPosition.getOrderStayFee();
        log.info("递延费 = {}", orderStayFee);

        BigDecimal spreadRatePrice = userPosition.getSpreadRatePrice();
        log.info("点差费 = {}", spreadRatePrice);

        BigDecimal sell_fee_amt = all_sell_amt.multiply(siteSetting.getSellFee()).setScale(2, 4);
        log.info("卖出手续费 = {}", sell_fee_amt);


        BigDecimal all_fee_amt = buy_fee_amt.add(sell_fee_amt).add(orderSpread).add(orderStayFee).add(spreadRatePrice);
        log.info("总的手续费费用 = {}", all_fee_amt);

        userPosition.setSellOrderId(GeneratePosition.getPositionId());
        userPosition.setSellOrderPrice(now_price);
        userPosition.setSellOrderTime(new Date());

        BigDecimal order_fee_all = buy_fee_amt.add(sell_fee_amt);
        userPosition.setOrderFee(order_fee_all);

        userPosition.setProfitAndLose(profitLoss);

        BigDecimal all_profit = profitLoss.subtract(all_fee_amt);
        userPosition.setAllProfitAndLose(all_profit);

        int updatePositionCount = this.userPositionMapper.updateByPrimaryKeySelective(userPosition);
        if (updatePositionCount > 0) {
            log.info("【用户平仓】修改浮动盈亏记录成功");
        } else {
            log.error("用户平仓】修改浮动盈亏记录出错");
            throw new Exception("用户平仓】修改浮动盈亏记录出错");
        }
        BigDecimal freez_amt = all_buy_amt.divide(new BigDecimal(userPosition.getOrderLever().intValue()), 2, 4);


        BigDecimal reckon_all = user_all_amt.add(all_profit);

        BigDecimal reckon_enable = user_enable_amt.add(all_profit).add(freez_amt).add(userPosition.getMarginAdd());

        log.info("用户平仓后的总资金  = {} , 可用资金 = {}", reckon_all, reckon_enable);
        user.setUserAmt(reckon_all);
        user.setEnableAmt(reckon_enable);
        int updateUserCount = this.userMapper.updateByPrimaryKeySelective(user);
        if (updateUserCount > 0) {
            log.info("【用户平仓】修改用户金额成功");
        } else {
            log.error("用户平仓】修改用户金额出错");
            throw new Exception("用户平仓】修改用户金额出错");
        }
        UserCashDetail ucd = new UserCashDetail();
        ucd.setPositionId(userPosition.getId());
        ucd.setAgentId(user.getAgentId());
        ucd.setAgentName(user.getAgentName());
        ucd.setUserId(user.getId());
        ucd.setUserName(user.getRealName());
        ucd.setDeType("总盈亏");
        ucd.setDeAmt(all_profit);
        ucd.setDeSummary("卖出股票，" + userPosition.getStockCode() + "/" + userPosition.getStockName() + ",占用本金：" + freez_amt + ",总手续费：" + all_fee_amt + ",递延费：" + orderStayFee + ",印花税：" + orderSpread + ",盈亏：" + profitLoss + "，总盈亏：" + all_profit);

        ucd.setAddTime(new Date());
        ucd.setIsRead(Integer.valueOf(0));

        int insertSxfCount = this.userCashDetailMapper.insert(ucd);
        if (insertSxfCount > 0) {
            this.iAgentAgencyFeeService.AgencyFeeIncome(2, userPosition.getPositionSn());

            this.iAgentAgencyFeeService.AgencyFeeIncome(4, userPosition.getPositionSn());
            log.info("【用户平仓】保存明细记录成功");
        } else {
            log.error("用户平仓】保存明细记录出错");
            throw new Exception("用户平仓】保存明细记录出错");
        }
        return ServerResponse.createBySuccessMsg("平仓成功！");
    }

    public ServerResponse addmargin(String positionSn, int doType, BigDecimal marginAdd)
            throws Exception {
        log.info("【用户追加保证金】 positionSn = {} ， dotype = {}", positionSn, Integer.valueOf(doType));

        SiteSetting siteSetting = this.iSiteSettingService.getSiteSetting();
        if (siteSetting == null) {
            log.error("追加保证金出错，网站设置表不存在");
            return ServerResponse.createByErrorMsg("追加失败，系统设置错误");
        }
        if (doType != 0) {
        }
        UserPosition userPosition = this.userPositionMapper.findPositionBySn(positionSn);
        if (userPosition == null) {
            return ServerResponse.createByErrorMsg("追加失败，订单不存在");
        }
        User user = this.userMapper.selectByPrimaryKey(userPosition.getUserId());

        SiteProduct siteProduct = this.iSiteProductService.getProductSetting();
        if (!siteProduct.getStockMarginDisplay().booleanValue()) {
            return ServerResponse.createByErrorMsg("不允许追加，请联系管理员");
        }
        if (siteProduct.getHolidayDisplay().booleanValue()) {
            return ServerResponse.createByErrorMsg("周末或节假日不能交易！");
        }
        if ((siteProduct.getRealNameDisplay().booleanValue()) && (user.getIsLock().intValue() == 1)) {
            return ServerResponse.createByErrorMsg("追加失败，用户已被锁定");
        }
        if (1 == userPosition.getIsLock().intValue()) {
            return ServerResponse.createByErrorMsg("追加失败 " + userPosition.getLockMsg());
        }
        BigDecimal user_all_amt = user.getUserAmt();
        BigDecimal user_enable_amt = user.getEnableAmt();
        int compareUserAmtInt = user_enable_amt.compareTo(marginAdd);
        log.info("用户可用金额 = {}  追加金额 =  {}", user_enable_amt, marginAdd);
        log.info("比较 用户金额 和 实际 购买金额 =  {}", Integer.valueOf(compareUserAmtInt));
        if (compareUserAmtInt == -1) {
            return ServerResponse.createByErrorMsg("追加失败，融资可用金额小于" + marginAdd + "元");
        }
        userPosition.setMarginAdd(userPosition.getMarginAdd().add(marginAdd));

        int updatePositionCount = this.userPositionMapper.updateByPrimaryKeySelective(userPosition);
        if (updatePositionCount > 0) {
            log.info("【用户追加保证金】追加保证金成功");
        } else {
            log.error("用户追加保证金】追加保证金出错");
            throw new Exception("用户追加保证金】追加保证金出错");
        }
        BigDecimal reckon_enable = user_enable_amt.subtract(marginAdd);

        log.info("用户追加保证金后的总资金  = {} , 可用资金 = {}", user_all_amt, reckon_enable);
        user.setEnableAmt(reckon_enable);
        int updateUserCount = this.userMapper.updateByPrimaryKeySelective(user);
        if (updateUserCount > 0) {
            log.info("【用户平仓】修改用户金额成功");
        } else {
            log.error("用户平仓】修改用户金额出错");
            throw new Exception("用户平仓】修改用户金额出错");
        }
        UserCashDetail ucd = new UserCashDetail();
        ucd.setPositionId(userPosition.getId());
        ucd.setAgentId(user.getAgentId());
        ucd.setAgentName(user.getAgentName());
        ucd.setUserId(user.getId());
        ucd.setUserName(user.getRealName());
        ucd.setDeType("追加保证金");
        ucd.setDeAmt(marginAdd.multiply(new BigDecimal("-1")));
        ucd.setDeSummary("追加股票，" + userPosition.getStockCode() + "/" + userPosition.getStockName() + ",追加金额：" + marginAdd);

        ucd.setAddTime(new Date());
        ucd.setIsRead(Integer.valueOf(0));

        int insertSxfCount = this.userCashDetailMapper.insert(ucd);
        if (insertSxfCount > 0) {
            log.info("【用户平仓】保存明细记录成功");
        } else {
            log.error("用户平仓】保存明细记录出错");
            throw new Exception("用户平仓】保存明细记录出错");
        }
        return ServerResponse.createBySuccessMsg("追加成功！");
    }

    public ServerResponse lock(Integer positionId, Integer state, String lockMsg) {
        if ((positionId == null) || (state == null)) {
            return ServerResponse.createByErrorMsg("参数不能为空");
        }
        UserPosition position = this.userPositionMapper.selectByPrimaryKey(positionId);
        if (position == null) {
            return ServerResponse.createByErrorMsg("持仓不存在");
        }
        if (position.getSellOrderId() != null) {
            return ServerResponse.createByErrorMsg("平仓单不能锁仓");
        }
        if ((state.intValue() == 1) &&
                (StringUtils.isBlank(lockMsg))) {
            return ServerResponse.createByErrorMsg("锁仓提示信息必填");
        }
        if (state.intValue() == 1) {
            position.setIsLock(Integer.valueOf(1));
            position.setLockMsg(lockMsg);
        } else {
            position.setIsLock(Integer.valueOf(0));
        }
        int updateCount = this.userPositionMapper.updateByPrimaryKeySelective(position);
        if (updateCount > 0) {
            return ServerResponse.createBySuccessMsg("操作成功");
        }
        return ServerResponse.createByErrorMsg("操作失败");
    }

    public ServerResponse del(Integer positionId) {
        if (positionId == null) {
            return ServerResponse.createByErrorMsg("id不能为空");
        }
        UserPosition position = this.userPositionMapper.selectByPrimaryKey(positionId);
        if (position == null) {
            ServerResponse.createByErrorMsg("该持仓不存在");
        }
        int updateCount = this.userPositionMapper.deleteByPrimaryKey(positionId);
        if (updateCount > 0) {
            return ServerResponse.createBySuccessMsg("删除成功");
        }
        return ServerResponse.createByErrorMsg("删除失败");
    }

    public ServerResponse findMyPositionByCodeAndSpell(String stockCode, String stockSpell, Integer state, HttpServletRequest request, int pageNum, int pageSize) {
        User user = this.iUserService.getCurrentUser(request);

        PageHelper.startPage(pageNum, pageSize);


        List<UserPosition> userPositions = this.userPositionMapper.findMyPositionByCodeAndSpell(user.getId(), stockCode, stockSpell, state);

        List<UserPositionVO> userPositionVOS = Lists.newArrayList();
        if (userPositions.size() > 0) {
            for (UserPosition position : userPositions) {
                UserPositionVO userPositionVO = assembleUserPositionVO(position);
                userPositionVOS.add(userPositionVO);
            }
        }
        PageInfo pageInfo = new PageInfo(userPositions);
        pageInfo.setList(userPositionVOS);

        return ServerResponse.createBySuccess(pageInfo);
    }

    public PositionVO findUserPositionAllProfitAndLose(Integer userId) {
        List<UserPosition> userPositions = this.userPositionMapper.findPositionByUserIdAndSellIdIsNull(userId);

        BigDecimal allProfitAndLose = new BigDecimal("0");
        BigDecimal allFreezAmt = new BigDecimal("0");
        for (Iterator localIterator = userPositions.iterator(); localIterator.hasNext(); ) {
            UserPosition position = (UserPosition) localIterator.next();

            StockListVO stockListVO = SinaStockApi.assembleStockListVO(
                    SinaStockApi.getSinaStock(position.getStockGid()));

            BigDecimal nowPrice = new BigDecimal(stockListVO.getNowPrice());
            if (nowPrice.compareTo(new BigDecimal("0")) != 0) {
                BigDecimal buyPrice = position.getBuyOrderPrice();
                BigDecimal subPrice = nowPrice.subtract(buyPrice);

                BigDecimal profit_and_lose = subPrice.multiply(new BigDecimal(position.getOrderNum().intValue()));
                if ("买跌".equals(position.getOrderDirection())) {
                    profit_and_lose = profit_and_lose.negate();
                }
                BigDecimal total_fee = position.getOrderFee().add(position.getOrderSpread()).add(position.getOrderStayFee());


                BigDecimal position_profit = profit_and_lose.subtract(total_fee);


                allProfitAndLose = allProfitAndLose.add(position_profit);


                BigDecimal position_freez = position.getOrderTotalPrice().divide(new BigDecimal(position.getOrderLever().intValue()), 2, 4);

                allFreezAmt = allFreezAmt.add(position_freez).add(position.getMarginAdd());
            } else {
                log.info("查询所有持仓单的总盈亏，现价返回0，当前为集合竞价");
            }
        }
        UserPosition position;
        List<FundsApply> fundsApplyList = this.fundsApplyMapper.getUserMarginList(userId.intValue());
        for (FundsApply fundsApply :  fundsApplyList) {
            allFreezAmt = allFreezAmt.add(fundsApply.getMargin());
        }
        PositionVO positionVO = new PositionVO();
        positionVO.setAllProfitAndLose(allProfitAndLose);
        positionVO.setAllFreezAmt(allFreezAmt);
        return positionVO;
    }

    public List<UserPosition> findPositionByUserIdAndSellIdIsNull(Integer userId) {
        return this.userPositionMapper.findPositionByUserIdAndSellIdIsNull(userId);
    }

    public List<UserPosition> findPositionByStockCodeAndTimes(int minuteTimes, String stockCode, Integer userId) {
        Date paramTimes = null;
        paramTimes = DateTimeUtil.parseToDateByMinute(minuteTimes);

        return this.userPositionMapper.findPositionByStockCodeAndTimes(paramTimes, stockCode, userId);
    }

    public Integer findPositionNumByTimes(int minuteTimes, Integer userId) {
        Date beginDate = DateTimeUtil.parseToDateByMinute(minuteTimes);
        Integer transNum = this.userPositionMapper.findPositionNumByTimes(beginDate, userId);
        log.info("用户 {} 在 {} 分钟之内 交易手数 {}", new Object[]{userId, Integer.valueOf(minuteTimes), transNum});
        return transNum;
    }

    public ServerResponse listByAgent(Integer positionType, Integer state, Integer userId, Integer agentId, String positionSn, String beginTime, String endTime, HttpServletRequest request, int pageNum, int pageSize) {
        AgentUser currentAgent = this.iAgentUserService.getCurrentAgent(request);
        if (agentId != null) {
            AgentUser agentUser = this.agentUserMapper.selectByPrimaryKey(agentId);
            if ((agentUser != null) && (agentUser.getParentId() != currentAgent.getId())) {
                return ServerResponse.createByErrorMsg("不能查询非下级代理用户持仓");
            }
        }
        Integer searchId = null;
        if (agentId == null) {
            searchId = currentAgent.getId();
        } else {
            searchId = agentId;
        }
        Timestamp begin_time = null;
        if (StringUtils.isNotBlank(beginTime)) {
            begin_time = DateTimeUtil.searchStrToTimestamp(beginTime);
        }
        Timestamp end_time = null;
        if (StringUtils.isNotBlank(endTime)) {
            end_time = DateTimeUtil.searchStrToTimestamp(endTime);
        }
        PageHelper.startPage(pageNum, pageSize);


        List<UserPosition> userPositions = this.userPositionMapper.listByAgent(positionType, state, userId, searchId, positionSn, begin_time, end_time);

        List<AgentPositionVO> agentPositionVOS = Lists.newArrayList();
        for (UserPosition position : userPositions) {
            AgentPositionVO agentPositionVO = assembleAgentPositionVO(position);
            agentPositionVOS.add(agentPositionVO);
        }
        PageInfo pageInfo = new PageInfo(userPositions);
        pageInfo.setList(agentPositionVOS);

        return ServerResponse.createBySuccess(pageInfo);
    }

    public ServerResponse getIncome(Integer agentId, Integer positionType, String beginTime, String endTime) {
        if ((StringUtils.isBlank(beginTime)) || (StringUtils.isBlank(endTime))) {
            return ServerResponse.createByErrorMsg("时间不能为空");
        }
        Timestamp begin_time = null;
        if (StringUtils.isNotBlank(beginTime)) {
            begin_time = DateTimeUtil.searchStrToTimestamp(beginTime);
        }
        Timestamp end_time = null;
        if (StringUtils.isNotBlank(endTime)) {
            end_time = DateTimeUtil.searchStrToTimestamp(endTime);
        }
        List<UserPosition> userPositions = this.userPositionMapper.listByAgent(positionType, Integer.valueOf(1), null, agentId, null, begin_time, end_time);


        BigDecimal order_fee_amt = new BigDecimal("0");
        BigDecimal order_profit_and_lose = new BigDecimal("0");
        BigDecimal order_profit_and_lose_all = new BigDecimal("0");
        for (UserPosition position : userPositions) {
            order_fee_amt = order_fee_amt.add(position.getOrderFee()).add(position.getOrderSpread()).add(position.getOrderStayFee());

            order_profit_and_lose = order_profit_and_lose.add(position.getProfitAndLose());

            order_profit_and_lose_all = order_profit_and_lose_all.add(position.getAllProfitAndLose());
        }
        AgentIncomeVO agentIncomeVO = new AgentIncomeVO();
        agentIncomeVO.setOrderSize(Integer.valueOf(userPositions.size()));
        agentIncomeVO.setOrderFeeAmt(order_fee_amt);
        agentIncomeVO.setOrderProfitAndLose(order_profit_and_lose);
        agentIncomeVO.setOrderAllAmt(order_profit_and_lose_all);

        return ServerResponse.createBySuccess(agentIncomeVO);
    }

    public ServerResponse listByAdmin(Integer agentId, Integer positionType, Integer state, Integer userId, String positionSn, String beginTime, String endTime, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);


        Timestamp begin_time = null;
        if (StringUtils.isNotBlank(beginTime)) {
            begin_time = DateTimeUtil.searchStrToTimestamp(beginTime);
        }
        Timestamp end_time = null;
        if (StringUtils.isNotBlank(endTime)) {
            end_time = DateTimeUtil.searchStrToTimestamp(endTime);
        }
        List<UserPosition> userPositions = this.userPositionMapper.listByAgent(positionType, state, userId, agentId, positionSn, begin_time, end_time);

        List<AdminPositionVO> adminPositionVOS = Lists.newArrayList();
        for (UserPosition position : userPositions) {
            AdminPositionVO adminPositionVO = assembleAdminPositionVO(position);
            adminPositionVOS.add(adminPositionVO);
        }
        PageInfo pageInfo = new PageInfo(userPositions);
        pageInfo.setList(adminPositionVOS);

        return ServerResponse.createBySuccess(pageInfo);
    }

    public int CountPositionNum(Integer state, Integer accountType) {
        return this.userPositionMapper.CountPositionNum(state, accountType);
    }

    public BigDecimal CountPositionProfitAndLose() {
        return this.userPositionMapper.CountPositionProfitAndLose();
    }

    public BigDecimal CountPositionAllProfitAndLose() {
        return this.userPositionMapper.CountPositionAllProfitAndLose();
    }

    public ServerResponse create(Integer userId, String stockCode, String buyPrice, String buyTime, Integer buyNum, Integer buyType, Integer lever) {
        if ((userId == null) || (StringUtils.isBlank(buyPrice)) || (StringUtils.isBlank(stockCode)) ||
                (StringUtils.isBlank(buyTime)) || (buyNum == null) || (buyType == null) || (lever == null)) {
            return ServerResponse.createByErrorMsg("参数不能为空");
        }
        User user = this.userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return ServerResponse.createByErrorMsg("用户不存在");
        }
        if (user.getAccountType().intValue() != 1) {
            return ServerResponse.createByErrorMsg("正式用户不能生成持仓单");
        }
        Stock stock = (Stock) this.iStockService.findStockByCode(stockCode).getData();
        if (stock == null) {
            return ServerResponse.createByErrorMsg("股票不存在");
        }
        SiteSetting siteSetting = this.iSiteSettingService.getSiteSetting();
        if (siteSetting == null) {
            log.error("下单出错，网站设置表不存在");
            return ServerResponse.createByErrorMsg("下单失败，系统设置错误");
        }
        BigDecimal user_enable_amt = user.getEnableAmt();

        BigDecimal buy_amt = new BigDecimal(buyPrice).multiply(new BigDecimal(buyNum.intValue()));
        BigDecimal buy_amt_autual = buy_amt.divide(new BigDecimal(lever.intValue()), 2, 4);


        int compareUserAmtInt = user_enable_amt.compareTo(buy_amt_autual);
        log.info("用户可用金额 = {}  实际购买金额 =  {}", user_enable_amt, buy_amt_autual);
        log.info("比较 用户金额 和 实际 购买金额 =  {}", Integer.valueOf(compareUserAmtInt));
        if (compareUserAmtInt == -1) {
            return ServerResponse.createByErrorMsg("下单失败，用户可用金额小于" + buy_amt_autual + "元");
        }
        BigDecimal reckon_enable = user_enable_amt.subtract(buy_amt_autual);
        user.setEnableAmt(reckon_enable);
        int updateUserCount = this.userMapper.updateByPrimaryKeySelective(user);
        if (updateUserCount > 0) {
            log.info("【用户交易下单】修改用户金额成功");
        } else {
            log.error("用户交易下单】修改用户金额出错");
        }
        UserPosition userPosition = new UserPosition();
        userPosition.setPositionType(Integer.valueOf(1));
        userPosition.setPositionSn(KeyUtils.getUniqueKey());
        userPosition.setUserId(user.getId());
        userPosition.setNickName(user.getRealName());
        userPosition.setAgentId(user.getAgentId());
        userPosition.setStockCode(stock.getStockCode());
        userPosition.setStockName(stock.getStockName());
        userPosition.setStockGid(stock.getStockGid());
        userPosition.setStockSpell(stock.getStockSpell());
        userPosition.setBuyOrderId(GeneratePosition.getPositionId());
        userPosition.setBuyOrderTime(DateTimeUtil.strToDate(buyTime));
        userPosition.setBuyOrderPrice(new BigDecimal(buyPrice));
        userPosition.setOrderDirection(buyType.intValue() == 0 ? "买涨" : "买跌");

        userPosition.setOrderNum(buyNum);


        userPosition.setIsLock(Integer.valueOf(0));


        userPosition.setOrderLever(lever);


        userPosition.setOrderTotalPrice(buy_amt);


        BigDecimal buy_fee_amt = buy_amt.multiply(siteSetting.getBuyFee()).setScale(2, 4);
        log.info("创建模拟持仓 手续费（配资后总资金 * 百分比） = {}", buy_fee_amt);
        userPosition.setOrderFee(buy_fee_amt);


        BigDecimal buy_yhs_amt = buy_amt.multiply(siteSetting.getDutyFee()).setScale(2, 4);
        log.info("创建模拟持仓 印花税（配资后总资金 * 百分比） = {}", buy_yhs_amt);
        userPosition.setOrderSpread(buy_yhs_amt);


        BigDecimal profit_and_lose = new BigDecimal("0");
        userPosition.setProfitAndLose(profit_and_lose);


        BigDecimal all_profit_and_lose = profit_and_lose.subtract(buy_fee_amt).subtract(buy_yhs_amt);
        userPosition.setAllProfitAndLose(all_profit_and_lose);


        userPosition.setOrderStayDays(Integer.valueOf(0));
        userPosition.setOrderStayFee(new BigDecimal("0"));
        userPosition.setSpreadRatePrice(new BigDecimal("0"));

        int insertPositionCount = this.userPositionMapper.insert(userPosition);
        if (insertPositionCount > 0) {
            log.info("【创建模拟持仓】保存记录成功");
        } else {
            log.error("【创建模拟持仓】保存记录出错");
        }
        return ServerResponse.createBySuccess("生成模拟持仓成功");
    }

    public int deleteByUserId(Integer userId) {
        return this.userPositionMapper.deleteByUserId(userId);
    }

    public void doClosingStayTask() {
        List<UserPosition> userPositions = this.userPositionMapper.findAllStayPosition();
        if (userPositions.size() > 0) {
            log.info("查询到正在持仓的订单数量 = {}", Integer.valueOf(userPositions.size()));

            SiteProduct siteProduct = this.iSiteProductService.getProductSetting();
            if (!siteProduct.getHolidayDisplay().booleanValue()) {
                for (UserPosition position : userPositions) {
                    int stayDays = GetStayDays.getDays(GetStayDays.getBeginDate(position.getBuyOrderTime()));

                    stayDays += 1;

                    log.info("");
                    log.info("开始处理 持仓订单id = {} 订单号 = {} 用户id = {} realName = {} 留仓天数 = {}", new Object[]{position
                            .getId(), position.getPositionSn(), position.getUserId(), position
                            .getNickName(), Integer.valueOf(stayDays)});
                    if (stayDays != 0) {
                        log.info(" 开始收取 {} 天 留仓费", Integer.valueOf(stayDays));
                        try {
                            closingStayTask(position, Integer.valueOf(stayDays));
                        } catch (Exception e) {
                            log.error("doClosingStayTask = ", e);
                        }
                    } else {
                        log.info("持仓订单 = {} ,持仓天数0天,不需要处理...", position.getId());
                    }
                    log.info("修改留仓费 处理结束。");
                    log.info("");
                }
                SiteTaskLog stl = new SiteTaskLog();
                stl.setTaskType("扣除留仓费");
                stl.setAddTime(new Date());
                stl.setIsSuccess(Integer.valueOf(0));
                stl.setTaskTarget("扣除留仓费，订单数量为" + userPositions.size());
                this.siteTaskLogMapper.insert(stl);
            }
        } else {
            log.info("doClosingStayTask没有正在持仓的订单");
        }
    }

    public void expireStayUnwindTask() {
        List<UserPosition> userPositions = this.userPositionMapper.findAllStayPosition();
        SiteSetting siteSetting;
        if (userPositions.size() > 0) {
            log.info("查询到正在持仓的订单数量 = {}", Integer.valueOf(userPositions.size()));

            siteSetting = this.iSiteSettingService.getSiteSetting();
            for (UserPosition position : userPositions) {
                int stayDays = GetStayDays.getDays(GetStayDays.getBeginDate(position.getBuyOrderTime()));

                log.info("");
                log.info("开始处理 持仓订单id = {} 订单号 = {} 用户id = {} realName = {} 留仓天数 = {}", new Object[]{position
                        .getId(), position.getPositionSn(), position.getUserId(), position
                        .getNickName(), Integer.valueOf(stayDays)});
                if (stayDays >= siteSetting.getStayMaxDays().intValue()) {
                    log.info(" 开始强平 {} 天", Integer.valueOf(stayDays));
                    try {
                        sell(position.getPositionSn(), 0);
                    } catch (Exception e) {
                        log.error("expireStayUnwindTask = ", e);
                    }
                } else {
                    log.info("持仓订单 = {} ,持仓天数0天,不需要处理...", position.getId());
                }
            }
        } else {
            log.info("doClosingStayTask没有正在持仓的订单");
        }
    }

    @Transactional
    public ServerResponse closingStayTask(UserPosition position, Integer stayDays)
            throws Exception {
        log.info("=================closingStayTask====================");
        log.info("修改留仓费，持仓id={},持仓天数={}", position.getId(), stayDays);

        SiteSetting siteSetting = this.iSiteSettingService.getSiteSetting();
        if (siteSetting == null) {
            log.error("修改留仓费出错，网站设置表不存在");
            return ServerResponse.createByErrorMsg("修改留仓费出错，网站设置表不存在");
        }
        BigDecimal stayFee = position.getOrderTotalPrice().multiply(siteSetting.getStayFee());

        BigDecimal allStayFee = stayFee.multiply(new BigDecimal(stayDays.intValue()));

        log.info("总留仓费 = {}", allStayFee);


        position.setOrderStayFee(allStayFee);
        position.setOrderStayDays(stayDays);

        BigDecimal all_profit = position.getAllProfitAndLose().subtract(allStayFee);
        position.setAllProfitAndLose(all_profit);

        int updateCount = this.userPositionMapper.updateByPrimaryKeySelective(position);
        if (updateCount > 0) {
            this.iAgentAgencyFeeService.AgencyFeeIncome(3, position.getPositionSn());
            log.info("【closingStayTask收持仓费】修改持仓记录成功");
        } else {
            log.error("【closingStayTask收持仓费】修改持仓记录出错");
            throw new Exception("【closingStayTask收持仓费】修改持仓记录出错");
        }
        log.info("=======================================================");
        return ServerResponse.createBySuccess();
    }

    public List<Integer> findDistinctUserIdList() {
        return this.userPositionMapper.findDistinctUserIdList();
    }

    private AdminPositionVO assembleAdminPositionVO(UserPosition position) {
        AdminPositionVO adminPositionVO = new AdminPositionVO();

        adminPositionVO.setId(position.getId());
        adminPositionVO.setPositionSn(position.getPositionSn());
        adminPositionVO.setPositionType(position.getPositionType());
        adminPositionVO.setUserId(position.getUserId());
        adminPositionVO.setNickName(position.getNickName());
        adminPositionVO.setAgentId(position.getAgentId());
        adminPositionVO.setStockName(position.getStockName());
        adminPositionVO.setStockCode(position.getStockCode());
        adminPositionVO.setStockGid(position.getStockGid());
        adminPositionVO.setStockSpell(position.getStockSpell());
        adminPositionVO.setBuyOrderId(position.getBuyOrderId());
        adminPositionVO.setBuyOrderTime(position.getBuyOrderTime());
        adminPositionVO.setBuyOrderPrice(position.getBuyOrderPrice());
        adminPositionVO.setSellOrderId(position.getSellOrderId());
        adminPositionVO.setSellOrderTime(position.getSellOrderTime());
        adminPositionVO.setSellOrderPrice(position.getSellOrderPrice());
        adminPositionVO.setOrderDirection(position.getOrderDirection());
        adminPositionVO.setOrderNum(position.getOrderNum());
        adminPositionVO.setOrderLever(position.getOrderLever());
        adminPositionVO.setOrderTotalPrice(position.getOrderTotalPrice());
        adminPositionVO.setOrderFee(position.getOrderFee());
        adminPositionVO.setOrderSpread(position.getOrderSpread());
        adminPositionVO.setOrderStayFee(position.getOrderStayFee());
        adminPositionVO.setOrderStayDays(position.getOrderStayDays());

        adminPositionVO.setIsLock(position.getIsLock());
        adminPositionVO.setLockMsg(position.getLockMsg());

        adminPositionVO.setStockPlate(position.getStockPlate());

        PositionProfitVO positionProfitVO = getPositionProfitVO(position);
        adminPositionVO.setProfitAndLose(positionProfitVO.getProfitAndLose());
        adminPositionVO.setAllProfitAndLose(positionProfitVO.getAllProfitAndLose());
        adminPositionVO.setNow_price(positionProfitVO.getNowPrice());


        return adminPositionVO;
    }

    private AgentPositionVO assembleAgentPositionVO(UserPosition position) {
        AgentPositionVO agentPositionVO = new AgentPositionVO();

        agentPositionVO.setId(position.getId());
        agentPositionVO.setPositionSn(position.getPositionSn());
        agentPositionVO.setPositionType(position.getPositionType());
        agentPositionVO.setUserId(position.getUserId());
        agentPositionVO.setNickName(position.getNickName());
        agentPositionVO.setAgentId(position.getAgentId());
        agentPositionVO.setStockName(position.getStockName());
        agentPositionVO.setStockCode(position.getStockCode());
        agentPositionVO.setStockGid(position.getStockGid());
        agentPositionVO.setStockSpell(position.getStockSpell());
        agentPositionVO.setBuyOrderId(position.getBuyOrderId());
        agentPositionVO.setBuyOrderTime(position.getBuyOrderTime());
        agentPositionVO.setBuyOrderPrice(position.getBuyOrderPrice());
        agentPositionVO.setSellOrderId(position.getSellOrderId());
        agentPositionVO.setSellOrderTime(position.getSellOrderTime());
        agentPositionVO.setSellOrderPrice(position.getSellOrderPrice());
        agentPositionVO.setOrderDirection(position.getOrderDirection());
        agentPositionVO.setOrderNum(position.getOrderNum());
        agentPositionVO.setOrderLever(position.getOrderLever());
        agentPositionVO.setOrderTotalPrice(position.getOrderTotalPrice());
        agentPositionVO.setOrderFee(position.getOrderFee());
        agentPositionVO.setOrderSpread(position.getOrderSpread());
        agentPositionVO.setOrderStayFee(position.getOrderStayFee());
        agentPositionVO.setOrderStayDays(position.getOrderStayDays());

        agentPositionVO.setIsLock(position.getIsLock());
        agentPositionVO.setLockMsg(position.getLockMsg());

        agentPositionVO.setStockPlate(position.getStockPlate());

        PositionProfitVO positionProfitVO = getPositionProfitVO(position);
        agentPositionVO.setProfitAndLose(positionProfitVO.getProfitAndLose());
        agentPositionVO.setAllProfitAndLose(positionProfitVO.getAllProfitAndLose());
        agentPositionVO.setNow_price(positionProfitVO.getNowPrice());


        return agentPositionVO;
    }

    private UserPositionVO assembleUserPositionVO(UserPosition position) {
        UserPositionVO userPositionVO = new UserPositionVO();

        userPositionVO.setId(position.getId());
        userPositionVO.setPositionType(position.getPositionType());
        userPositionVO.setPositionSn(position.getPositionSn());
        userPositionVO.setUserId(position.getUserId());
        userPositionVO.setNickName(position.getNickName());
        userPositionVO.setAgentId(position.getAgentId());
        userPositionVO.setStockName(position.getStockName());
        userPositionVO.setStockCode(position.getStockCode());
        userPositionVO.setStockGid(position.getStockGid());
        userPositionVO.setStockSpell(position.getStockSpell());
        userPositionVO.setBuyOrderId(position.getBuyOrderId());
        userPositionVO.setBuyOrderTime(position.getBuyOrderTime());
        userPositionVO.setBuyOrderPrice(position.getBuyOrderPrice());
        userPositionVO.setSellOrderId(position.getSellOrderId());
        userPositionVO.setSellOrderTime(position.getSellOrderTime());
        userPositionVO.setSellOrderPrice(position.getSellOrderPrice());
        userPositionVO.setProfitTargetPrice(position.getProfitTargetPrice());
        userPositionVO.setStopTargetPrice(position.getStopTargetPrice());
        userPositionVO.setOrderDirection(position.getOrderDirection());
        userPositionVO.setOrderNum(position.getOrderNum());
        userPositionVO.setOrderLever(position.getOrderLever());
        userPositionVO.setOrderTotalPrice(position.getOrderTotalPrice());
        userPositionVO.setOrderFee(position.getOrderFee());
        userPositionVO.setOrderSpread(position.getOrderSpread());
        userPositionVO.setOrderStayFee(position.getOrderStayFee());
        userPositionVO.setOrderStayDays(position.getOrderStayDays());
        userPositionVO.setMarginAdd(position.getMarginAdd());

        userPositionVO.setStockPlate(position.getStockPlate());
        userPositionVO.setSpreadRatePrice(position.getSpreadRatePrice());

        PositionProfitVO positionProfitVO = getPositionProfitVO(position);
        userPositionVO.setProfitAndLose(positionProfitVO.getProfitAndLose());
        userPositionVO.setAllProfitAndLose(positionProfitVO.getAllProfitAndLose());
        userPositionVO.setNow_price(positionProfitVO.getNowPrice());


        return userPositionVO;
    }

    public PositionProfitVO getPositionProfitVO(UserPosition position) {
        BigDecimal profitAndLose = new BigDecimal("0");
        BigDecimal allProfitAndLose = new BigDecimal("0");
        String nowPrice = "";
        if (position.getSellOrderId() != null) {
            BigDecimal subPrice = position.getSellOrderPrice().subtract(position.getBuyOrderPrice());

            profitAndLose = subPrice.multiply(new BigDecimal(position.getOrderNum().intValue()));
            if ("买跌".equals(position.getOrderDirection())) {
                profitAndLose = profitAndLose.negate();
            }
            allProfitAndLose = profitAndLose.subtract(position.getOrderFee()).subtract(position.getOrderSpread()).subtract(position.getOrderStayFee()).subtract(position.getSpreadRatePrice());
        } else {
            StockListVO stockListVO = SinaStockApi.assembleStockListVO(
                    SinaStockApi.getSinaStock(position.getStockGid()));
            nowPrice = stockListVO.getNowPrice();


            BigDecimal subPrice = new BigDecimal(nowPrice).subtract(position.getBuyOrderPrice());

            profitAndLose = subPrice.multiply(new BigDecimal(position.getOrderNum().intValue()));
            if ("买跌".equals(position.getOrderDirection())) {
                profitAndLose = profitAndLose.negate();
            }
            allProfitAndLose = profitAndLose.subtract(position.getOrderFee()).subtract(position.getOrderSpread()).subtract(position.getOrderStayFee()).subtract(position.getSpreadRatePrice());
        }
        PositionProfitVO positionProfitVO = new PositionProfitVO();
        positionProfitVO.setProfitAndLose(profitAndLose);
        positionProfitVO.setAllProfitAndLose(allProfitAndLose);
        positionProfitVO.setNowPrice(nowPrice);

        return positionProfitVO;
    }

    public ServerResponse findPositionTopList(Integer pageSize) {
        List<UserPosition> userPositions = this.userPositionMapper.findPositionTopList(pageSize);

        List<UserPositionVO> userPositionVOS = Lists.newArrayList();
        if (userPositions.size() > 0) {
            for (UserPosition position : userPositions) {
                UserPositionVO userPositionVO = assembleUserPositionVO(position);
                userPositionVOS.add(userPositionVO);
            }
        }
        PageInfo pageInfo = new PageInfo(userPositions);
        pageInfo.setList(userPositionVOS);

        return ServerResponse.createBySuccess(pageInfo);
    }

    public ServerResponse findUserPositionByCode(HttpServletRequest request, String stockCode) {
        User user = this.iUserService.getCurrentRefreshUser(request);
        UserPosition position = this.userPositionMapper.findUserPositionByCode(user.getId(), stockCode);

        List<UserPositionVO> userPositionVOS = Lists.newArrayList();
        UserPositionVO userPositionVO = null;
        if (position != null) {
            userPositionVO = assembleUserPositionVO(position);
        }
        userPositionVOS.add(userPositionVO);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setList(userPositionVOS);

        return ServerResponse.createBySuccess(pageInfo);
    }
}
