package com.xc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.xc.common.ServerResponse;
import com.xc.dao.StockIndexMapper;
import com.xc.pojo.StockIndex;
import com.xc.pojo.User;
import com.xc.service.IStockIndexService;
import com.xc.service.IStockOptionService;
import com.xc.service.IUserService;
import com.xc.utils.HttpClientRequest;
import com.xc.utils.PropertiesUtil;
import com.xc.vo.stock.MarketVO;
import com.xc.vo.stockindex.StockIndexVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service("iStockIndexService")
public class StockIndexServiceImpl
  implements IStockIndexService
{
  private static final Logger log = LoggerFactory.getLogger(StockIndexServiceImpl.class);
  @Autowired
  StockIndexMapper stockIndexMapper;
  @Autowired
  IUserService iUserService;
  @Autowired
  IStockOptionService iStockOptionService;
  
  public ServerResponse listByAdmin(Integer homeShow, Integer listShow, Integer transState, String indexCode, String indexName, int pageNum, int pageSize, HttpServletRequest request)
  {
    PageHelper.startPage(pageNum, pageSize);
    
    List<StockIndex> stockIndexList = this.stockIndexMapper.listByAdmin(homeShow, listShow, transState, indexCode, indexName);
    List<StockIndexVO> stockIndexVOS = Lists.newArrayList();
    for (StockIndex stockIndex : stockIndexList)
    {
      StockIndexVO stockIndexVO = assembleStockIndexVO(stockIndex);
      stockIndexVOS.add(stockIndexVO);
    }
    PageInfo pageInfo = new PageInfo(stockIndexList);
    pageInfo.setList(stockIndexVOS);
    
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  private StockIndexVO assembleStockIndexVO(StockIndex stockIndex)
  {
    StockIndexVO stockIndexVO = new StockIndexVO();
    
    stockIndexVO.setId(stockIndex.getId());
    stockIndexVO.setIndexName(stockIndex.getIndexName());
    stockIndexVO.setIndexCode(stockIndex.getIndexCode());
    stockIndexVO.setIndexGid(stockIndex.getIndexGid());
    stockIndexVO.setHomeShow(stockIndex.getHomeShow());
    stockIndexVO.setListShow(stockIndex.getListShow());
    stockIndexVO.setTransState(stockIndex.getTransState());
    stockIndexVO.setDepositAmt(stockIndex.getDepositAmt());
    stockIndexVO.setTransFee(stockIndex.getTransFee());
    stockIndexVO.setEachPoint(stockIndex.getEachPoint());
    stockIndexVO.setMinNum(stockIndex.getMinNum());
    stockIndexVO.setMaxNum(stockIndex.getMaxNum());
    stockIndexVO.setAddTime(stockIndex.getAddTime());
    stockIndexVO.setTDesc(stockIndex.getTDesc());
    

    MarketVO marketVO = querySingleIndex(stockIndex.getIndexGid());
    
    stockIndexVO.setCurrentPoint(marketVO.getNowPrice());
    stockIndexVO.setFloatPoint(marketVO.getIncrease());
    stockIndexVO.setFloatRate(marketVO.getIncreaseRate());
    
    return stockIndexVO;
  }
  
  public ServerResponse updateIndex(StockIndex stockIndex)
  {
    if (stockIndex.getId() == null) {
      return ServerResponse.createByErrorMsg("修改id不能为空");
    }
    StockIndex dbindex = this.stockIndexMapper.selectByPrimaryKey(stockIndex.getId());
    dbindex.setHomeShow(stockIndex.getHomeShow());
    dbindex.setListShow(stockIndex.getListShow());
    dbindex.setTransState(stockIndex.getTransState());
    dbindex.setDepositAmt(stockIndex.getDepositAmt());
    dbindex.setTransFee(stockIndex.getTransFee());
    dbindex.setEachPoint(stockIndex.getEachPoint());
    dbindex.setMinNum(stockIndex.getMinNum());
    dbindex.setMaxNum(stockIndex.getMaxNum());
    
    int updateCount = this.stockIndexMapper.updateByPrimaryKey(dbindex);
    if (updateCount > 0) {
      return ServerResponse.createBySuccessMsg("修改成功");
    }
    return ServerResponse.createByErrorMsg("修改失败");
  }
  
  public ServerResponse addIndex(StockIndex stockIndex)
  {
    log.info("name = {} code = {} gid = {}", new Object[] {stockIndex
      .getIndexName(), stockIndex.getIndexCode(), stockIndex.getIndexGid() });
    if ((StringUtils.isBlank(stockIndex.getIndexName())) || 
      (StringUtils.isBlank(stockIndex.getIndexCode())) || 
      (StringUtils.isBlank(stockIndex.getIndexGid()))) {
      return ServerResponse.createByErrorMsg("参数不能为空");
    }
    StockIndex nameIndex = this.stockIndexMapper.selectIndexByName(stockIndex.getIndexName());
    if (nameIndex != null) {
      return ServerResponse.createByErrorMsg("指数名称已存在");
    }
    StockIndex codeIndex = this.stockIndexMapper.selectIndexByCode(stockIndex.getIndexCode());
    if (codeIndex != null) {
      return ServerResponse.createByErrorMsg("指数代码已存在");
    }
    stockIndex.setAddTime(new Date());
    int insertCount = this.stockIndexMapper.insert(stockIndex);
    if (insertCount > 0) {
      return ServerResponse.createBySuccessMsg("添加成功");
    }
    return ServerResponse.createByErrorMsg("添加失败");
  }
  
  public ServerResponse queryHomeIndex()
  {
    List<StockIndex> list = this.stockIndexMapper.queryHomeIndex();
    List<StockIndexVO> stockIndexVOS = Lists.newArrayList();
    for (StockIndex stockIndex : list)
    {
      StockIndexVO stockIndexVO = assembleStockIndexVO(stockIndex);
      stockIndexVOS.add(stockIndexVO);
    }
    return ServerResponse.createBySuccess(stockIndexVOS);
  }
  
  public ServerResponse queryListIndex(HttpServletRequest request)
  {
    List<StockIndex> list = this.stockIndexMapper.queryListIndex();
    List<StockIndexVO> stockIndexVOS = Lists.newArrayList();
    User user = this.iUserService.getCurrentUser(request);
    for (StockIndex stockIndex : list)
    {
      StockIndexVO stockIndexVO = assembleStockIndexVO(stockIndex);
      if (user == null) {
        stockIndexVO.setIsOption("0");
      } else {
        stockIndexVO.setIsOption(this.iStockOptionService.isMyOption(user.getId(), stockIndex.getIndexCode()));
      }
      stockIndexVOS.add(stockIndexVO);
    }
    return ServerResponse.createBySuccess(stockIndexVOS);
  }
  
  public ServerResponse queryTransIndex(Integer indexId)
  {
    StockIndex stockIndex = this.stockIndexMapper.selectByPrimaryKey(indexId);
    if (1 == stockIndex.getTransState().intValue()) {
      return ServerResponse.createBySuccessMsg("可交易");
    }
    return ServerResponse.createByErrorMsg("不可交易");
  }
  
  public MarketVO querySingleIndex(String indexCode)
  {
    String market_url = PropertiesUtil.getProperty("sina.single.market.url");
    
    String result = null;
    try
    {
      market_url = market_url + indexCode;
      


      result = HttpClientRequest.doGet(market_url);
    }
    catch (Exception e)
    {
      log.error("获取 大盘指数 出错 e = {}", e);
    }
    MarketVO marketVO = null;
    try
    {
      if (StringUtils.isNotBlank(result))
      {
        result = result.substring(result.indexOf("\"") + 1, result.lastIndexOf("\""));
        
        marketVO = new MarketVO();
        if (result.contains(","))
        {
          String[] sh01_arr = result.split(",");
          marketVO.setName(sh01_arr[0]);
          marketVO.setNowPrice(sh01_arr[1]);
          marketVO.setIncrease(sh01_arr[2]);
          marketVO.setIncreaseRate(sh01_arr[3]);
        }
      }
    }
    catch (Exception e)
    {
      log.error("转换大盘指数出错 str = {} ,  e = {}", result, e);
    }
    return marketVO;
  }
  
  public StockIndex selectIndexById(Integer indexId)
  {
    return this.stockIndexMapper.selectByPrimaryKey(indexId);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.StockIndexServiceImpl

 * JD-Core Version:    0.7.0.1

 */