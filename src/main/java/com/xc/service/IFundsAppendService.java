package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.FundsAppend;

import javax.servlet.http.HttpServletRequest;

public abstract interface IFundsAppendService
{
  public abstract int insert(FundsAppend paramFundsAppend);
  
  public abstract int update(FundsAppend paramFundsAppend);
  
  public abstract ServerResponse save(FundsAppend paramFundsAppend, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse<PageInfo> getList(int paramInt1, int paramInt2, String paramString, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse getDetail(int paramInt);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IFundsAppendService

 * JD-Core Version:    0.7.0.1

 */