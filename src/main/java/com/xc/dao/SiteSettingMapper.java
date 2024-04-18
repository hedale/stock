package com.xc.dao;

import com.xc.pojo.SiteSetting;

import java.util.List;

public abstract interface SiteSettingMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(SiteSetting paramSiteSetting);
  
  public abstract int insertSelective(SiteSetting paramSiteSetting);
  
  public abstract SiteSetting selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(SiteSetting paramSiteSetting);
  
  public abstract int updateByPrimaryKey(SiteSetting paramSiteSetting);
  
  public abstract List findAllSiteSetting();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SiteSettingMapper

 * JD-Core Version:    0.7.0.1

 */