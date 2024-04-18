package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.SiteNews;

import javax.servlet.http.HttpServletRequest;

public abstract interface ISiteNewsService
{
  public abstract int insert(SiteNews paramSiteNews);
  
  public abstract int update(SiteNews paramSiteNews);
  
  public abstract ServerResponse save(SiteNews paramSiteNews);
  
  public abstract ServerResponse<PageInfo> getList(int paramInt1, int paramInt2, Integer paramInteger, String paramString1, String paramString2, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse getDetail(int paramInt);
  
  public abstract int grabNews();
  
  public abstract ServerResponse updateViews(Integer paramInteger);
  
  public abstract ServerResponse getTopNewsList(int paramInt);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.ISiteNewsService

 * JD-Core Version:    0.7.0.1

 */