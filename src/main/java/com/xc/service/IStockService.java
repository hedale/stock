package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.Stock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public abstract interface IStockService
{
  public abstract ServerResponse getMarket();
  
  public abstract ServerResponse getStock(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, HttpServletRequest paramHttpServletRequest);
  
  public abstract void z1();
  
  public abstract void z11();
  
  public abstract void z12();
  
  public abstract void z2();
  
  public abstract void z21();
  
  public abstract void z22();
  
  public abstract void z3();
  
  public abstract void z31();
  
  public abstract void z32();
  
  public abstract void z4();
  
  public abstract void z41();
  
  public abstract void z42();
  
  public abstract void h1();
  
  public abstract void h11();
  
  public abstract void h12();
  
  public abstract void h2();
  
  public abstract void h21();
  
  public abstract void h22();
  
  public abstract void h3();
  
  public abstract void h31();
  
  public abstract void h32();
  
  public abstract ServerResponse getDateline(HttpServletResponse paramHttpServletResponse, String paramString);
  
  public abstract ServerResponse getSingleStock(String paramString);
  
  public abstract ServerResponse getMinK(String paramString, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);
  
  public abstract ServerResponse getMinK_Echarts(String paramString, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);
  
  public abstract ServerResponse getFuturesMinK_Echarts(String paramString, Integer paramInteger1, Integer paramInteger2);
  
  public abstract ServerResponse getIndexMinK_Echarts(String paramString, Integer paramInteger1, Integer paramInteger2);
  
  public abstract ServerResponse getDayK_Echarts(String paramString);
  
  public abstract ServerResponse getFuturesDayK(String paramString);
  
  public abstract ServerResponse getIndexDayK(String paramString);
  
  public abstract ServerResponse<Stock> findStockByName(String paramString);
  
  public abstract ServerResponse<Stock> findStockByCode(String paramString);
  
  public abstract ServerResponse<Stock> findStockById(Integer paramInteger);
  
  public abstract ServerResponse<PageInfo> listByAdmin(Integer paramInteger1, Integer paramInteger2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse updateLock(Integer paramInteger);
  
  public abstract ServerResponse updateShow(Integer paramInteger);
  
  public abstract ServerResponse addStock(String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger1, Integer paramInteger2);
  
  public abstract int CountStockNum();
  
  public abstract int CountShowNum(Integer paramInteger);
  
  public abstract int CountUnLockNum(Integer paramInteger);
  
  public abstract List findStockList();
  
  public abstract ServerResponse selectRateByDaysAndStockCode(String paramString, int paramInt);
  
  public abstract ServerResponse updateStock(Stock paramStock);
  
  public abstract ServerResponse deleteByPrimaryKey(Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IStockService

 * JD-Core Version:    0.7.0.1

 */