package com.xc.service;

import com.xc.common.ServerResponse;
import com.xc.pojo.SiteFuturesSetting;

public abstract interface ISiteFuturesSettingService
{
  public abstract SiteFuturesSetting getSetting();
  
  public abstract ServerResponse update(SiteFuturesSetting paramSiteFuturesSetting);
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.service.ISiteFuturesSettingService
 * JD-Core Version:    0.7.0.1
 */