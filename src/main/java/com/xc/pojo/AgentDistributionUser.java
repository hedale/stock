package com.xc.pojo;

import java.io.Serializable;
import java.util.Date;

public class AgentDistributionUser
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer id;
  private Integer agentId;
  private Integer parentId;
  private Integer parentLevel;
  private Date addTime;
  private Date updateTime;
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public Integer getAgentId()
  {
    return this.agentId;
  }
  
  public void setAgentId(Integer agentId)
  {
    this.agentId = agentId;
  }
  
  public Integer getParentId()
  {
    return this.parentId;
  }
  
  public void setParentId(Integer parentId)
  {
    this.parentId = parentId;
  }
  
  public Integer getParentLevel()
  {
    return this.parentLevel;
  }
  
  public void setParentLevel(Integer parentLevel)
  {
    this.parentLevel = parentLevel;
  }
  
  public Date getAddTime()
  {
    return this.addTime;
  }
  
  public void setAddTime(Date addTime)
  {
    this.addTime = addTime;
  }
  
  public Date getUpdateTime()
  {
    return this.updateTime;
  }
  
  public void setUpdateTime(Date updateTime)
  {
    this.updateTime = updateTime;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.AgentDistributionUser
 * JD-Core Version:    0.7.0.1
 */