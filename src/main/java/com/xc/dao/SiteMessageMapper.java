package com.xc.dao;

import com.xc.pojo.SiteMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface SiteMessageMapper
{
  public abstract int insert(SiteMessage paramSiteMessage);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(SiteMessage paramSiteMessage);
  
  public abstract SiteMessage load(int paramInt);
  
  public abstract List getSiteMessageByUserIdList(@Param("userId") Integer paramInteger);
  
  public abstract int getIsDayCount(@Param("userId") Integer paramInteger, @Param("typeName") String paramString);
  
  public abstract int updateMessageStatus(@Param("userId") Integer paramInteger);
  
  public abstract int getUnreadCount(@Param("userId") Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SiteMessageMapper

 * JD-Core Version:    0.7.0.1

 */