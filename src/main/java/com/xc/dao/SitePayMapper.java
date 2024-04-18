package com.xc.dao;

import com.xc.pojo.SitePay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface SitePayMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(SitePay paramSitePay);
  
  public abstract int insertSelective(SitePay paramSitePay);
  
  public abstract SitePay selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(SitePay paramSitePay);
  
  public abstract int updateByPrimaryKey(SitePay paramSitePay);
  
  public abstract SitePay findByChannelType(@Param("channelType") String paramString);
  
  public abstract List<SitePay> listByAdmin(@Param("channelType") String paramString);
  
  public abstract List getPayInfo();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SitePayMapper

 * JD-Core Version:    0.7.0.1

 */