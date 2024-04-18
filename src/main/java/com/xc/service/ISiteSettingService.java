package com.xc.service;

import com.xc.common.ServerResponse;
import com.xc.pojo.SiteSetting;

public abstract interface ISiteSettingService
{
  public abstract SiteSetting getSiteSetting();
  
  public abstract ServerResponse update(SiteSetting paramSiteSetting);
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.service.ISiteSettingService
 * JD-Core Version:    0.7.0.1
 */