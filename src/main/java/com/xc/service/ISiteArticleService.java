package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.SiteArticle;

public abstract interface ISiteArticleService
{
  public abstract ServerResponse<PageInfo> listByAdmin(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract ServerResponse add(SiteArticle paramSiteArticle);
  
  public abstract ServerResponse update(SiteArticle paramSiteArticle);
  
  public abstract ServerResponse detail(Integer paramInteger);
  
  public abstract ServerResponse list(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract ServerResponse getTopArtList(int paramInt);
  
  public abstract int grabArticle();
  
  public abstract ServerResponse del(Integer paramInteger);
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.service.ISiteArticleService
 * JD-Core Version:    0.7.0.1
 */