package com.xc.dao;

import com.xc.pojo.SiteSmsLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface SiteSmsLogMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(SiteSmsLog paramSiteSmsLog);
  
  public abstract int insertSelective(SiteSmsLog paramSiteSmsLog);
  
  public abstract SiteSmsLog selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(SiteSmsLog paramSiteSmsLog);
  
  public abstract int updateByPrimaryKey(SiteSmsLog paramSiteSmsLog);
  
  public abstract List smsList(@Param("phoneNum") String paramString);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SiteSmsLogMapper

 * JD-Core Version:    0.7.0.1

 */