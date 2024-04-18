package com.xc.pojo;

import java.util.Date;

public class SiteArticle
{
  private Integer id;
  private String artTitle;
  private String artType;
  private String artImg;
  private String author;
  private Integer hitTimes;
  private Integer isShow;
  private Date addTime;
  private String artSummary;
  private String artCnt;
  private String spiderUrl;
  private String sourceId;
  private Integer views;
  
  public SiteArticle(Integer id, String artTitle, String artType, String artImg, String author, Integer hitTimes, Integer isShow, Date addTime, String artSummary, String artCnt, String spiderUrl, String sourceId, Integer views)
  {
    this.id = id;
    
    this.artTitle = artTitle;
    
    this.artType = artType;
    
    this.artImg = artImg;
    
    this.author = author;
    
    this.hitTimes = hitTimes;
    
    this.isShow = isShow;
    
    this.addTime = addTime;
    
    this.artSummary = artSummary;
    
    this.artCnt = artCnt;
    
    this.spiderUrl = spiderUrl;
    this.sourceId = sourceId;
    this.views = views;
  }
  
  public SiteArticle() {}
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public String getArtTitle()
  {
    return this.artTitle;
  }
  
  public void setArtTitle(String artTitle)
  {
    this.artTitle = artTitle;
  }
  
  public String getArtType()
  {
    return this.artType;
  }
  
  public void setArtType(String artType)
  {
    this.artType = artType;
  }
  
  public String getArtImg()
  {
    return this.artImg;
  }
  
  public void setArtImg(String artImg)
  {
    this.artImg = artImg;
  }
  
  public String getAuthor()
  {
    return this.author;
  }
  
  public void setAuthor(String author)
  {
    this.author = author;
  }
  
  public Integer getHitTimes()
  {
    return this.hitTimes;
  }
  
  public void setHitTimes(Integer hitTimes)
  {
    this.hitTimes = hitTimes;
  }
  
  public Integer getIsShow()
  {
    return this.isShow;
  }
  
  public void setIsShow(Integer isShow)
  {
    this.isShow = isShow;
  }
  
  public Date getAddTime()
  {
    return this.addTime;
  }
  
  public void setAddTime(Date addTime)
  {
    this.addTime = addTime;
  }
  
  public String getArtSummary()
  {
    return this.artSummary;
  }
  
  public void setArtSummary(String artSummary)
  {
    this.artSummary = artSummary;
  }
  
  public String getArtCnt()
  {
    return this.artCnt;
  }
  
  public void setArtCnt(String artCnt)
  {
    this.artCnt = artCnt;
  }
  
  public String getSpiderUrl()
  {
    return this.spiderUrl;
  }
  
  public void setSpiderUrl(String spiderUrl)
  {
    this.spiderUrl = spiderUrl;
  }
  
  public String getSourceId()
  {
    return this.sourceId;
  }
  
  public void setSourceId(String sourceId)
  {
    this.sourceId = sourceId;
  }
  
  public Integer getViews()
  {
    return this.views;
  }
  
  public void setViews(Integer views)
  {
    this.views = views;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.SiteArticle
 * JD-Core Version:    0.7.0.1
 */