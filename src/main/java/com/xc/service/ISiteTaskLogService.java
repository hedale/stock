package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;

public abstract interface ISiteTaskLogService
{
  public abstract ServerResponse<PageInfo> taskList(String paramString, int paramInt1, int paramInt2);
  
  public abstract ServerResponse del(Integer paramInteger, HttpServletRequest paramHttpServletRequest);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.ISiteTaskLogService

 * JD-Core Version:    0.7.0.1

 */