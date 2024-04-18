package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.StockCoin;

import java.util.List;

public abstract interface IStockCoinService
{
  public abstract ServerResponse<PageInfo> listByAdmin(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract ServerResponse add(StockCoin paramStockCoin);
  
  public abstract ServerResponse update(StockCoin paramStockCoin);
  
  public abstract StockCoin selectCoinByCode(String paramString);
  
  public abstract List getSelectCoin();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IStockCoinService

 * JD-Core Version:    0.7.0.1

 */