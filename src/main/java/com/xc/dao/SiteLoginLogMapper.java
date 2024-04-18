package com.xc.dao;

import com.xc.pojo.SiteLoginLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface SiteLoginLogMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(SiteLoginLog paramSiteLoginLog);
  
  public abstract int insertSelective(SiteLoginLog paramSiteLoginLog);
  
  public abstract SiteLoginLog selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(SiteLoginLog paramSiteLoginLog);
  
  public abstract int updateByPrimaryKey(SiteLoginLog paramSiteLoginLog);
  
  public abstract List loginList(@Param("userId") Integer paramInteger);
  
  public abstract int deleteByUserId(@Param("userId") Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SiteLoginLogMapper

 * JD-Core Version:    0.7.0.1

 */