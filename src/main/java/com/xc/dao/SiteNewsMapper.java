package com.xc.dao;

import com.xc.pojo.SiteNews;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public abstract interface SiteNewsMapper
{
  public abstract int insert(SiteNews paramSiteNews);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(SiteNews paramSiteNews);
  
  public abstract SiteNews load(int paramInt);
  
  public abstract List<SiteNews> pageList(@Param("pageNum") int paramInt1, @Param("pageSize") int paramInt2, @Param("type") Integer paramInteger, @Param("sort") String paramString1, @Param("keyword") String paramString2);
  
  public abstract int pageListCount(int paramInt1, int paramInt2);
  
  public abstract int getNewsBySourceIdCount(@Param("sourceId") String paramString);
  
  public abstract int updateViews(@Param("id") Integer paramInteger);
  
  public abstract List<SiteNews> getTopNewsList(@Param("pageSize") int paramInt);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SiteNewsMapper

 * JD-Core Version:    0.7.0.1

 */