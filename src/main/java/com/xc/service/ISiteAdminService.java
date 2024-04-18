package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.SiteAdmin;

import javax.servlet.http.HttpServletRequest;

public abstract interface ISiteAdminService
{
  public abstract ServerResponse login(String paramString1, String paramString2, String paramString3, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse<PageInfo> listByAdmin(String paramString1, String paramString2, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract ServerResponse authCharge(String paramString1, Integer paramInteger, String paramString2);
  
  public abstract ServerResponse updateLock(Integer paramInteger);
  
  public abstract ServerResponse add(SiteAdmin paramSiteAdmin);
  
  public abstract ServerResponse update(SiteAdmin paramSiteAdmin);
  
  public abstract SiteAdmin findAdminByName(String paramString);
  
  public abstract SiteAdmin findAdminByPhone(String paramString);
  
  public abstract ServerResponse count();
  
  public abstract ServerResponse deleteAdmin(Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.ISiteAdminService

 * JD-Core Version:    0.7.0.1

 */