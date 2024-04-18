package com.xc.service;

import com.xc.common.ServerResponse;

public abstract interface RealTimeService
{
  public abstract ServerResponse deleteRealTime();
  
  public abstract ServerResponse deleteFuturesRealTime();
  
  public abstract ServerResponse findStock(String paramString);
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.service.RealTimeService
 * JD-Core Version:    0.7.0.1
 */