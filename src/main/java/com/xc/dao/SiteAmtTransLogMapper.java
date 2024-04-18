package com.xc.dao;

import com.xc.pojo.SiteAmtTransLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface SiteAmtTransLogMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(SiteAmtTransLog paramSiteAmtTransLog);
  
  public abstract int insertSelective(SiteAmtTransLog paramSiteAmtTransLog);
  
  public abstract SiteAmtTransLog selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(SiteAmtTransLog paramSiteAmtTransLog);
  
  public abstract int updateByPrimaryKey(SiteAmtTransLog paramSiteAmtTransLog);
  
  public abstract List transList(@Param("userId") Integer paramInteger, @Param("realName") String paramString);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SiteAmtTransLogMapper

 * JD-Core Version:    0.7.0.1

 */