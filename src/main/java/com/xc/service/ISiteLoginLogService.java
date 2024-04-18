package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.User;

import javax.servlet.http.HttpServletRequest;

public abstract interface ISiteLoginLogService
{
  public abstract ServerResponse saveLog(User paramUser, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse<PageInfo> loginList(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract int deleteByUserId(Integer paramInteger);
  
  public abstract ServerResponse del(Integer paramInteger, HttpServletRequest paramHttpServletRequest);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.ISiteLoginLogService

 * JD-Core Version:    0.7.0.1

 */