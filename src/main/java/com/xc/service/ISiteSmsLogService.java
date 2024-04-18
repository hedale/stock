package com.xc.service;

import com.xc.common.ServerResponse;
import com.xc.pojo.SiteSmsLog;

import javax.servlet.http.HttpServletRequest;

public abstract interface ISiteSmsLogService
{
  public abstract ServerResponse smsList(String paramString, int paramInt1, int paramInt2);
  
  public abstract void addData(SiteSmsLog paramSiteSmsLog);
  
  public abstract ServerResponse del(Integer paramInteger, HttpServletRequest paramHttpServletRequest);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.ISiteSmsLogService

 * JD-Core Version:    0.7.0.1

 */