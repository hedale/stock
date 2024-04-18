package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.SiteSpread;

import java.math.BigDecimal;

public abstract interface ISiteSpreadService
{
  public abstract int insert(SiteSpread paramSiteSpread);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(SiteSpread paramSiteSpread);
  
  public abstract SiteSpread load(int paramInt);
  
  public abstract ServerResponse<PageInfo> pageList(int paramInt1, int paramInt2, String paramString);
  
  public abstract SiteSpread findSpreadRateOne(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, String paramString, BigDecimal paramBigDecimal3);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.ISiteSpreadService

 * JD-Core Version:    0.7.0.1

 */