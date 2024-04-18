package com.xc.dao;

import com.xc.pojo.SiteTaskLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface SiteTaskLogMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(SiteTaskLog paramSiteTaskLog);
  
  public abstract int insertSelective(SiteTaskLog paramSiteTaskLog);
  
  public abstract SiteTaskLog selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(SiteTaskLog paramSiteTaskLog);
  
  public abstract int updateByPrimaryKey(SiteTaskLog paramSiteTaskLog);
  
  public abstract List taskList(@Param("taskType") String paramString);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SiteTaskLogMapper

 * JD-Core Version:    0.7.0.1

 */