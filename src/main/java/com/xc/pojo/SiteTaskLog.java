package com.xc.pojo;

import java.util.Date;

public class SiteTaskLog
{
  private Integer id;
  private String taskType;
  private String taskCnt;
  private String taskTarget;
  private Integer isSuccess;
  private String errorMsg;
  private Date addTime;
  
  public SiteTaskLog(Integer id, String taskType, String taskCnt, String taskTarget, Integer isSuccess, String errorMsg, Date addTime)
  {
    this.id = id;
    this.taskType = taskType;
    this.taskCnt = taskCnt;
    this.taskTarget = taskTarget;
    this.isSuccess = isSuccess;
    this.errorMsg = errorMsg;
    this.addTime = addTime;
  }
  
  public SiteTaskLog() {}
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public String getTaskType()
  {
    return this.taskType;
  }
  
  public void setTaskType(String taskType)
  {
    this.taskType = taskType;
  }
  
  public String getTaskCnt()
  {
    return this.taskCnt;
  }
  
  public void setTaskCnt(String taskCnt)
  {
    this.taskCnt = taskCnt;
  }
  
  public String getTaskTarget()
  {
    return this.taskTarget;
  }
  
  public void setTaskTarget(String taskTarget)
  {
    this.taskTarget = taskTarget;
  }
  
  public Integer getIsSuccess()
  {
    return this.isSuccess;
  }
  
  public void setIsSuccess(Integer isSuccess)
  {
    this.isSuccess = isSuccess;
  }
  
  public String getErrorMsg()
  {
    return this.errorMsg;
  }
  
  public void setErrorMsg(String errorMsg)
  {
    this.errorMsg = errorMsg;
  }
  
  public Date getAddTime()
  {
    return this.addTime;
  }
  
  public void setAddTime(Date addTime)
  {
    this.addTime = addTime;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.pojo.SiteTaskLog
 * JD-Core Version:    0.7.0.1
 */