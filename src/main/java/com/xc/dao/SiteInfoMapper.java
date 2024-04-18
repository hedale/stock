package com.xc.dao;

import com.xc.pojo.SiteInfo;

import java.util.List;

public abstract interface SiteInfoMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(SiteInfo paramSiteInfo);
  
  public abstract int insertSelective(SiteInfo paramSiteInfo);
  
  public abstract SiteInfo selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(SiteInfo paramSiteInfo);
  
  public abstract int updateByPrimaryKey(SiteInfo paramSiteInfo);
  
  public abstract List findAll();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SiteInfoMapper

 * JD-Core Version:    0.7.0.1

 */