package com.xc.service;

import com.xc.common.ServerResponse;
import com.xc.pojo.SiteInfo;

public abstract interface ISiteInfoService
{
  public abstract ServerResponse get();
  
  public abstract ServerResponse add(SiteInfo paramSiteInfo);
  
  public abstract ServerResponse update(SiteInfo paramSiteInfo);
  
  public abstract ServerResponse getInfo();
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.service.ISiteInfoService
 * JD-Core Version:    0.7.0.1
 */