package com.xc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.dao.FundsApplyMapper;
import com.xc.dao.FundsTradingAccountMapper;
import com.xc.dao.UserCashDetailMapper;
import com.xc.dao.UserMapper;
import com.xc.pojo.*;
import com.xc.service.IFundsApplyService;
import com.xc.service.IFundsSettingService;
import com.xc.service.IUserService;
import com.xc.utils.DateTimeUtil;
import com.xc.utils.KeyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("IFundsApplyService")
public class FundsApplyServiceImpl
  implements IFundsApplyService
{
  private static final Logger log = LoggerFactory.getLogger(FundsApplyServiceImpl.class);
  @Resource
  private FundsApplyMapper fundsApplyMapper;
  @Autowired
  UserMapper userMapper;
  @Autowired
  UserCashDetailMapper userCashDetailMapper;
  @Autowired
  FundsTradingAccountMapper fundsTradingAccountMapper;
  @Autowired
  IUserService iUserService;
  @Autowired
  IFundsSettingService iFundsSettingService;
  
  @Transactional
  public ServerResponse insert(FundsApply model, HttpServletRequest request)
    throws Exception
  {
    int ret = 0;
    if (model == null) {
      return ServerResponse.createBySuccessMsg("操作异常，请稍后重试！");
    }
    User user = this.iUserService.getCurrentRefreshUser(request);
    if (user == null) {
      return ServerResponse.createBySuccessMsg("请登录后操作");
    }
    BigDecimal user_enable_amt = user.getEnableAmt();
    
    BigDecimal pay_amount = model.getMargin().add(model.getManageFee());
    int compareUserAmtInt = user_enable_amt.compareTo(pay_amount);
    log.info("用户可用金额 = {}  实际购买金额 =  {} 比较结果 = {} ", new Object[] { user_enable_amt, pay_amount, Integer.valueOf(compareUserAmtInt) });
    if (compareUserAmtInt == -1) {
      return ServerResponse.createByErrorMsg("申请失败，可用金额小于" + pay_amount + "元");
    }
    model.setOrderNumber(KeyUtils.getUniqueKey());
    model.setPayAmount(pay_amount);
    ret = this.fundsApplyMapper.insert(model);
    if (ret > 0)
    {
      BigDecimal reckon_enable = user_enable_amt.subtract(pay_amount);
      user.setEnableAmt(reckon_enable);
      int updateUserCount = this.userMapper.updateByPrimaryKeySelective(user);
      if (updateUserCount > 0)
      {
        log.info("【用户交易下单】修改用户金额成功");
        UserCashDetail ucd = new UserCashDetail();
        ucd.setPositionId(model.getId());
        ucd.setAgentId(user.getAgentId());
        ucd.setAgentName(user.getAgentName());
        ucd.setUserId(user.getId());
        ucd.setUserName(user.getRealName());
        ucd.setDeType("配资冻结");
        ucd.setDeAmt(model.getPayAmount().multiply(new BigDecimal("-1")));
        ucd.setDeSummary("申请按天配资:" + model.getOrderNumber() + "，冻结金额：" + model.getPayAmount().multiply(new BigDecimal("-1")));
        ucd.setAddTime(new Date());
        ucd.setIsRead(Integer.valueOf(0));
        int insertSxfCount = this.userCashDetailMapper.insert(ucd);
        if (insertSxfCount > 0) {
          log.info("【按天配资】申请成功");
        }
      }
      else
      {
        log.error("【按天配资】修改用户金额出错");
        throw new Exception("【按天配资】修改用户金额出错");
      }
      return ServerResponse.createBySuccessMsg("申请成功！");
    }
    return ServerResponse.createBySuccessMsg("申请失败，请稍后重试！");
  }
  
  public int update(FundsApply model)
  {
    int ret = this.fundsApplyMapper.update(model);
    return ret > 0 ? ret : 0;
  }
  
  public ServerResponse save(FundsApply model)
  {
    int ret = 0;
    if ((model != null) && (model.getId().intValue() > 0)) {
      ret = this.fundsApplyMapper.update(model);
    } else {
      ret = this.fundsApplyMapper.insert(model);
    }
    if (ret > 0) {
      return ServerResponse.createBySuccessMsg("操作成功");
    }
    return ServerResponse.createByErrorMsg("操作失败");
  }
  
  @Transactional
  public ServerResponse audit(FundsApply model, HttpServletRequest request)
    throws Exception
  {
    FundsApply fundsApply = this.fundsApplyMapper.load(model.getId().intValue());
    int ret = 0;
    if ((model != null) && (model.getId().intValue() > 0))
    {
      User user = this.userMapper.selectByPrimaryKey(fundsApply.getUserId());
      if (model.getStatus().intValue() == 1)
      {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String begtime = df.format(new Date()).split(" ")[0] + " 0:00:00";
        Date date = DateTimeUtil.strToDate(begtime);
        Date begDate = DateTimeUtil.addDay(date, 1);
        model.setBeginTime(begDate);
        String endtime = df.format(new Date()).split(" ")[0] + " 23:59:59";
        Date endDate = DateTimeUtil.strToDate(endtime);
        endDate = DateTimeUtil.addDay(endDate, model.getTradersCycle().intValue() + 1);
        model.setEndTime(endDate);
        model.setEnabledTradingAmount(fundsApply.getTotalTradingAmount());
        FundsSetting fundsSetting = this.iFundsSettingService.getFundsSetting();
        
        BigDecimal lineUnwind = fundsApply.getMargin().multiply(fundsSetting.getDaysUnwind()).add(fundsApply.getFundsAmount()).setScale(2, 4);
        model.setLineUnwind(lineUnwind);
        
        BigDecimal lineWarning = fundsApply.getMargin().multiply(fundsSetting.getDaysWarning()).add(fundsApply.getFundsAmount()).setScale(2, 4);
        model.setLineWarning(lineWarning);
      }
      model.setAuditTime(DateTimeUtil.getCurrentDate());
      ret = this.fundsApplyMapper.update(model);
      if (ret > 0)
      {
        BigDecimal user_enable_amt = user.getEnableAmt();
        if (model.getStatus().intValue() == 1)
        {
          BigDecimal user_all_amt = user.getUserAmt();
          
          BigDecimal reckon_all = user_all_amt.subtract(fundsApply.getManageFee());
          
          BigDecimal tradingAmount = user.getTradingAmount().add(fundsApply.getTotalTradingAmount());
          log.info("【配资审核通过】用户平总资金  = {} , 可用资金 = {} , 总操盘资金 = {}", new Object[] { reckon_all, user_enable_amt, tradingAmount });
          user.setUserAmt(reckon_all);
          user.setTradingAmount(tradingAmount);
          int updateUserCount = this.userMapper.updateByPrimaryKeySelective(user);
          if (updateUserCount > 0)
          {
            log.info("【配资审核通过】修改用户金额成功");
            
            FundsTradingAccount fundsTradingAccount = this.fundsTradingAccountMapper.getAccountByNumber(model.getSubaccountNumber());
            if (fundsTradingAccount != null)
            {
              fundsTradingAccount.setStatus(Integer.valueOf(1));
              this.fundsTradingAccountMapper.update(fundsTradingAccount);
            }
            UserCashDetail ucd = new UserCashDetail();
            ucd.setPositionId(fundsApply.getId());
            ucd.setAgentId(user.getAgentId());
            ucd.setAgentName(user.getAgentName());
            ucd.setUserId(user.getId());
            ucd.setUserName(user.getRealName());
            ucd.setDeType("配资审核通过");
            ucd.setDeAmt(fundsApply.getPayAmount());
            ucd.setDeSummary("申请按天配资:" + fundsApply.getOrderNumber() + "，配资审核通过，解冻保证金到配资账户：" + fundsApply.getPayAmount());
            ucd.setAddTime(new Date());
            ucd.setIsRead(Integer.valueOf(0));
            int insertSxfCount = this.userCashDetailMapper.insert(ucd);
            if (insertSxfCount > 0) {
              log.info("【配资审核通过】申请成功");
            }
          }
          else
          {
            log.error("【配资审核通过】修改用户金额出错");
            throw new Exception("【配资审核通过】修改用户金额出错");
          }
        }
        else
        {
          BigDecimal reckon_enable = user_enable_amt.add(fundsApply.getPayAmount());
          user.setEnableAmt(reckon_enable);
          int updateUserCount = this.userMapper.updateByPrimaryKeySelective(user);
          if (updateUserCount > 0)
          {
            log.info("【配资审核未通过】修改用户金额成功");
            UserCashDetail ucd = new UserCashDetail();
            ucd.setPositionId(fundsApply.getId());
            ucd.setAgentId(user.getAgentId());
            ucd.setAgentName(user.getAgentName());
            ucd.setUserId(user.getId());
            ucd.setUserName(user.getRealName());
            ucd.setDeType("配资审核未通过");
            ucd.setDeAmt(fundsApply.getPayAmount());
            ucd.setDeSummary("申请按天配资:" + fundsApply.getOrderNumber() + "，配资审核未通过，解冻保证金到余额：" + fundsApply.getPayAmount() + "，原因：" + model.getAuditOpinion());
            ucd.setAddTime(new Date());
            ucd.setIsRead(Integer.valueOf(0));
            int insertSxfCount = this.userCashDetailMapper.insert(ucd);
            if (insertSxfCount > 0) {
              log.info("【按天配资】申请成功");
            }
          }
          else
          {
            log.error("【按天配资】修改用户金额出错");
            throw new Exception("【按天配资】修改用户金额出错");
          }
        }
        log.info("配资申请-审核 = {}  实际购买金额 =  {} 比较结果 = {} ", Integer.valueOf(0));
      }
    }
    if (ret > 0) {
      return ServerResponse.createBySuccessMsg("操作成功");
    }
    return ServerResponse.createByErrorMsg("操作失败");
  }
  
  public ServerResponse<PageInfo> getList(int pageNum, int pageSize, String keyword, Integer status, HttpServletRequest request)
  {
    PageHelper.startPage(pageNum, pageSize);
    List<FundsApply> listData = this.fundsApplyMapper.pageList(pageNum, pageSize, keyword, status);
    PageInfo pageInfo = new PageInfo(listData);
    pageInfo.setList(listData);
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  public ServerResponse getDetail(int id)
  {
    return ServerResponse.createBySuccess(this.fundsApplyMapper.load(id));
  }
  
  public ServerResponse<PageInfo> getUserApplyList(int pageNum, int pageSize, int userId, HttpServletRequest request)
  {
    User user = this.iUserService.getCurrentRefreshUser(request);
    PageHelper.startPage(pageNum, pageSize);
    List<FundsApply> listData = this.fundsApplyMapper.getUserApplyList(pageNum, pageSize, user.getId().intValue());
    PageInfo pageInfo = new PageInfo(listData);
    pageInfo.setList(listData);
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  public ServerResponse<PageInfo> getUserEnabledSubaccount(HttpServletRequest request)
  {
    User user = this.iUserService.getCurrentRefreshUser(request);
    List<FundsApply> listData = this.fundsApplyMapper.getUserEnabledSubaccount(user.getId().intValue());
    PageInfo pageInfo = new PageInfo();
    pageInfo.setList(listData);
    return ServerResponse.createBySuccess(pageInfo);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.FundsApplyServiceImpl

 * JD-Core Version:    0.7.0.1

 */