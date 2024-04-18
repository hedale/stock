package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;

public abstract interface IStockOptionService
{
  public abstract ServerResponse<PageInfo> findMyStockOptions(String paramString, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract ServerResponse isOption(Integer paramInteger, String paramString);
  
  public abstract String isMyOption(Integer paramInteger, String paramString);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IStockOptionService

 * JD-Core Version:    0.7.0.1

 */