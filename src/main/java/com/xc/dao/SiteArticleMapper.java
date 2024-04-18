package com.xc.dao;

import com.xc.pojo.SiteArticle;
import com.xc.pojo.SiteNews;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface SiteArticleMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(SiteArticle paramSiteArticle);
  
  public abstract int insertSelective(SiteArticle paramSiteArticle);
  
  public abstract SiteArticle selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(SiteArticle paramSiteArticle);
  
  public abstract int updateByPrimaryKey(SiteArticle paramSiteArticle);
  
  public abstract List listByAdmin(@Param("artTitle") String paramString1, @Param("artType") String paramString2);
  
  public abstract List list(@Param("artTitle") String paramString1, @Param("artType") String paramString2);
  
  public abstract List<SiteNews> getTopArtList(@Param("pageSize") int paramInt);
  
  public abstract int getArtBySourceIdCount(@Param("sourceId") String paramString);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SiteArticleMapper

 * JD-Core Version:    0.7.0.1

 */