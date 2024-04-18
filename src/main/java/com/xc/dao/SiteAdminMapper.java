package com.xc.dao;

import com.xc.pojo.SiteAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface SiteAdminMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(SiteAdmin paramSiteAdmin);
  
  public abstract int insertSelective(SiteAdmin paramSiteAdmin);
  
  public abstract SiteAdmin selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(SiteAdmin paramSiteAdmin);
  
  public abstract int updateByPrimaryKey(SiteAdmin paramSiteAdmin);
  
  public abstract SiteAdmin login(@Param("adminPhone") String paramString1, @Param("adminPwd") String paramString2);
  
  public abstract List listByAdmin(@Param("adminName") String paramString1, @Param("adminPhone") String paramString2, @Param("superAdmin") String paramString3);
  
  public abstract SiteAdmin findAdminByName(String paramString);
  
  public abstract SiteAdmin findAdminByPhone(String paramString);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SiteAdminMapper

 * JD-Core Version:    0.7.0.1

 */