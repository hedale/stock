package com.xc.pojo;

import java.io.Serializable;
import java.util.Date;

public class SiteNews
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer id;
  private Integer type;
  private String title;
  private String sourceId;
  private String sourceName;
  private Integer views;
  private Integer status;
  private Date showTime;
  private Date addTime;
  private Date updateTime;
  private String imgurl;
  private String description;
  private String content;
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $id = getId();result = result * 59 + ($id == null ? 43 : $id.hashCode());Object $type = getType();result = result * 59 + ($type == null ? 43 : $type.hashCode());Object $title = getTitle();result = result * 59 + ($title == null ? 43 : $title.hashCode());Object $sourceId = getSourceId();result = result * 59 + ($sourceId == null ? 43 : $sourceId.hashCode());Object $sourceName = getSourceName();result = result * 59 + ($sourceName == null ? 43 : $sourceName.hashCode());Object $views = getViews();result = result * 59 + ($views == null ? 43 : $views.hashCode());Object $status = getStatus();result = result * 59 + ($status == null ? 43 : $status.hashCode());Object $showTime = getShowTime();result = result * 59 + ($showTime == null ? 43 : $showTime.hashCode());Object $addTime = getAddTime();result = result * 59 + ($addTime == null ? 43 : $addTime.hashCode());Object $updateTime = getUpdateTime();result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());Object $imgurl = getImgurl();result = result * 59 + ($imgurl == null ? 43 : $imgurl.hashCode());Object $description = getDescription();result = result * 59 + ($description == null ? 43 : $description.hashCode());Object $content = getContent();result = result * 59 + ($content == null ? 43 : $content.hashCode());return result;
  }
  
  protected boolean canEqual(Object other)
  {
    return other instanceof SiteNews;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof SiteNews)) {
      return false;
    }
    SiteNews other = (SiteNews)o;
    if (!other.canEqual(this)) {
      return false;
    }
    Object this$id = getId();Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
      return false;
    }
    Object this$type = getType();Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
      return false;
    }
    Object this$title = getTitle();Object other$title = other.getTitle();
    if (this$title == null ? other$title != null : !this$title.equals(other$title)) {
      return false;
    }
    Object this$sourceId = getSourceId();Object other$sourceId = other.getSourceId();
    if (this$sourceId == null ? other$sourceId != null : !this$sourceId.equals(other$sourceId)) {
      return false;
    }
    Object this$sourceName = getSourceName();Object other$sourceName = other.getSourceName();
    if (this$sourceName == null ? other$sourceName != null : !this$sourceName.equals(other$sourceName)) {
      return false;
    }
    Object this$views = getViews();Object other$views = other.getViews();
    if (this$views == null ? other$views != null : !this$views.equals(other$views)) {
      return false;
    }
    Object this$status = getStatus();Object other$status = other.getStatus();
    if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
      return false;
    }
    Object this$showTime = getShowTime();Object other$showTime = other.getShowTime();
    if (this$showTime == null ? other$showTime != null : !this$showTime.equals(other$showTime)) {
      return false;
    }
    Object this$addTime = getAddTime();Object other$addTime = other.getAddTime();
    if (this$addTime == null ? other$addTime != null : !this$addTime.equals(other$addTime)) {
      return false;
    }
    Object this$updateTime = getUpdateTime();Object other$updateTime = other.getUpdateTime();
    if (this$updateTime == null ? other$updateTime != null : !this$updateTime.equals(other$updateTime)) {
      return false;
    }
    Object this$imgurl = getImgurl();Object other$imgurl = other.getImgurl();
    if (this$imgurl == null ? other$imgurl != null : !this$imgurl.equals(other$imgurl)) {
      return false;
    }
    Object this$description = getDescription();Object other$description = other.getDescription();
    if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
      return false;
    }
    Object this$content = getContent();Object other$content = other.getContent();return this$content == null ? other$content == null : this$content.equals(other$content);
  }
  
  public void setContent(String content)
  {
    this.content = content;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public void setImgurl(String imgurl)
  {
    this.imgurl = imgurl;
  }
  
  public void setUpdateTime(Date updateTime)
  {
    this.updateTime = updateTime;
  }
  
  public void setAddTime(Date addTime)
  {
    this.addTime = addTime;
  }
  
  public void setShowTime(Date showTime)
  {
    this.showTime = showTime;
  }
  
  public void setStatus(Integer status)
  {
    this.status = status;
  }
  
  public void setViews(Integer views)
  {
    this.views = views;
  }
  
  public void setSourceName(String sourceName)
  {
    this.sourceName = sourceName;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public void setType(Integer type)
  {
    this.type = type;
  }
  
  public String toString()
  {
    return "SiteNews(id=" + getId() + ", type=" + getType() + ", title=" + getTitle() + ", sourceId=" + getSourceId() + ", sourceName=" + getSourceName() + ", views=" + getViews() + ", status=" + getStatus() + ", showTime=" + getShowTime() + ", addTime=" + getAddTime() + ", updateTime=" + getUpdateTime() + ", imgurl=" + getImgurl() + ", description=" + getDescription() + ", content=" + getContent() + ")";
  }
  
  public void setSourceId(String sourceId)
  {
    this.sourceId = sourceId;
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public Integer getType()
  {
    return this.type;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getSourceId()
  {
    return this.sourceId;
  }
  
  public String getSourceName()
  {
    return this.sourceName;
  }
  
  public Integer getViews()
  {
    return this.views;
  }
  
  public Integer getStatus()
  {
    return this.status;
  }
  
  public Date getShowTime()
  {
    return this.showTime;
  }
  
  public Date getAddTime()
  {
    return this.addTime;
  }
  
  public Date getUpdateTime()
  {
    return this.updateTime;
  }
  
  public String getImgurl()
  {
    return this.imgurl;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public String getContent()
  {
    return this.content;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.SiteNews
 * JD-Core Version:    0.7.0.1
 */