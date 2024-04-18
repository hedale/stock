package com.xc.service;

import com.xc.common.ServerResponse;
import com.xc.pojo.StockIndex;
import com.xc.vo.stock.MarketVO;

import javax.servlet.http.HttpServletRequest;

public abstract interface IStockIndexService
{
  public abstract ServerResponse listByAdmin(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString1, String paramString2, int paramInt1, int paramInt2, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse updateIndex(StockIndex paramStockIndex);
  
  public abstract ServerResponse addIndex(StockIndex paramStockIndex);
  
  public abstract ServerResponse queryHomeIndex();
  
  public abstract ServerResponse queryListIndex(HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse queryTransIndex(Integer paramInteger);
  
  public abstract MarketVO querySingleIndex(String paramString);
  
  public abstract StockIndex selectIndexById(Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IStockIndexService

 * JD-Core Version:    0.7.0.1

 */