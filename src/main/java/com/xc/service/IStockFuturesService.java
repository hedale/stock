package com.xc.service;

import com.xc.common.ServerResponse;
import com.xc.pojo.StockFutures;
import com.xc.vo.foreigncurrency.ExchangeVO;
import com.xc.vo.stockfutures.FuturesVO;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public abstract interface IStockFuturesService
{
  public abstract ServerResponse listByAdmin(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract ServerResponse add(StockFutures paramStockFutures);
  
  public abstract ServerResponse update(StockFutures paramStockFutures);
  
  public abstract ServerResponse queryHome();
  
  public abstract ServerResponse queryList(HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse queryTrans(Integer paramInteger);
  
  public abstract FuturesVO querySingleMarket(String paramString);
  
  public abstract ServerResponse<ExchangeVO> queryExchangeVO(String paramString);
  
  public abstract ServerResponse<BigDecimal> getExchangeRate(String paramString);
  
  public abstract StockFutures selectFuturesById(Integer paramInteger);
  
  public abstract StockFutures selectFuturesByCode(String paramString);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IStockFuturesService

 * JD-Core Version:    0.7.0.1

 */