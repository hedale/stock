package com.xc.service;

import com.xc.common.ServerResponse;
import com.xc.pojo.SiteBanner;

public abstract interface ISiteBannerService
{
  public abstract ServerResponse add(SiteBanner paramSiteBanner);
  
  public abstract ServerResponse listByAdmin(int paramInt1, int paramInt2);
  
  public abstract ServerResponse update(SiteBanner paramSiteBanner);
  
  public abstract ServerResponse delete(Integer paramInteger);
  
  public abstract ServerResponse getBannerByPlat(String paramString);
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.service.ISiteBannerService
 * JD-Core Version:    0.7.0.1
 */