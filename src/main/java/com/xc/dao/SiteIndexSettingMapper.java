package com.xc.dao;

import com.xc.pojo.SiteIndexSetting;

import java.util.List;

public abstract interface SiteIndexSettingMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(SiteIndexSetting paramSiteIndexSetting);
  
  public abstract int insertSelective(SiteIndexSetting paramSiteIndexSetting);
  
  public abstract SiteIndexSetting selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(SiteIndexSetting paramSiteIndexSetting);
  
  public abstract int updateByPrimaryKey(SiteIndexSetting paramSiteIndexSetting);
  
  public abstract List selectAllSiteIndexSetting();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SiteIndexSettingMapper

 * JD-Core Version:    0.7.0.1

 */