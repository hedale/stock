package com.xc.dao;

import com.xc.pojo.SiteBanner;

import java.util.List;

public abstract interface SiteBannerMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(SiteBanner paramSiteBanner);
  
  public abstract int insertSelective(SiteBanner paramSiteBanner);
  
  public abstract SiteBanner selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(SiteBanner paramSiteBanner);
  
  public abstract int updateByPrimaryKey(SiteBanner paramSiteBanner);
  
  public abstract List listByAdmin();
  
  public abstract List getBannerByMobile();
  
  public abstract List getBannerByPC();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SiteBannerMapper

 * JD-Core Version:    0.7.0.1

 */