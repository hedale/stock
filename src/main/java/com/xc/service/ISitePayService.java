package com.xc.service;

import com.xc.common.ServerResponse;
import com.xc.pojo.SitePay;

public abstract interface ISitePayService
{
  public abstract ServerResponse add(SitePay paramSitePay);
  
  public abstract ServerResponse listByAdmin(String paramString, int paramInt1, int paramInt2);
  
  public abstract ServerResponse update(SitePay paramSitePay);
  
  public abstract ServerResponse del(Integer paramInteger);
  
  public abstract ServerResponse getPayInfo();
  
  public abstract ServerResponse getPayInfoById(Integer paramInteger);
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.service.ISitePayService
 * JD-Core Version:    0.7.0.1
 */