package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.SiteMessage;

import javax.servlet.http.HttpServletRequest;

public abstract interface ISiteMessageService
{
  public abstract int insert(SiteMessage paramSiteMessage);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(SiteMessage paramSiteMessage);
  
  public abstract ServerResponse<PageInfo> getSiteMessageByUserIdList(int paramInt1, int paramInt2, int paramInt3, HttpServletRequest paramHttpServletRequest);
  
  public abstract int getIsDayCount(Integer paramInteger, String paramString);
  
  public abstract int updateMessageStatus(HttpServletRequest paramHttpServletRequest);
  
  public abstract int getUnreadCount(HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse del(Integer paramInteger, HttpServletRequest paramHttpServletRequest);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.ISiteMessageService

 * JD-Core Version:    0.7.0.1

 */