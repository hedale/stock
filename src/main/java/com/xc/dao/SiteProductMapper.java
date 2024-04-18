package com.xc.dao;

import com.xc.pojo.SiteProduct;

import java.util.List;

public abstract interface SiteProductMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(SiteProduct paramSiteProduct);
  
  public abstract int insertSelective(SiteProduct paramSiteProduct);
  
  public abstract SiteProduct selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(SiteProduct paramSiteProduct);
  
  public abstract int updateByPrimaryKey(SiteProduct paramSiteProduct);
  
  public abstract List findAllSiteSetting();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SiteProductMapper

 * JD-Core Version:    0.7.0.1

 */