package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;

public abstract interface IUserCashDetailService
{
  public abstract ServerResponse<PageInfo> findUserCashDetailList(Integer paramInteger, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract ServerResponse<PageInfo> listByAgent(Integer paramInteger1, String paramString, Integer paramInteger2, Integer paramInteger3, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract ServerResponse<PageInfo> listByAdmin(Integer paramInteger1, String paramString, Integer paramInteger2, Integer paramInteger3, int paramInt1, int paramInt2);
  
  public abstract int deleteByUserId(Integer paramInteger);
  
  public abstract ServerResponse delCash(Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IUserCashDetailService

 * JD-Core Version:    0.7.0.1

 */