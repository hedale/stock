package com.xc.service;

import com.xc.common.ServerResponse;
import com.xc.pojo.SiteProduct;

public abstract interface ISiteProductService
{
  public abstract ServerResponse update(SiteProduct paramSiteProduct);
  
  public abstract SiteProduct getProductSetting();
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.service.ISiteProductService
 * JD-Core Version:    0.7.0.1
 */