package com.xc.service;

import com.xc.common.ServerResponse;
import com.xc.pojo.SiteIndexSetting;

public abstract interface ISiteIndexSettingService
{
  public abstract SiteIndexSetting getSiteIndexSetting();
  
  public abstract ServerResponse update(SiteIndexSetting paramSiteIndexSetting);
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.service.ISiteIndexSettingService
 * JD-Core Version:    0.7.0.1
 */