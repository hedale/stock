package com.xc.pojo;

import java.util.Date;

public class SiteSmsLog
{
  private Integer id;
  private String smsPhone;
  private String smsTitle;
  private String smsCnt;
  private String smsTemplate;
  private Integer smsStatus;
  private Date addTime;
  
  public SiteSmsLog(Integer id, String smsPhone, String smsTitle, String smsCnt, String smsTemplate, Integer smsStatus, Date addTime)
  {
    this.id = id;
    this.smsPhone = smsPhone;
    this.smsTitle = smsTitle;
    this.smsCnt = smsCnt;
    this.smsTemplate = smsTemplate;
    this.smsStatus = smsStatus;
    this.addTime = addTime;
  }
  
  public SiteSmsLog() {}
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public String getSmsPhone()
  {
    return this.smsPhone;
  }
  
  public void setSmsPhone(String smsPhone)
  {
    this.smsPhone = smsPhone;
  }
  
  public String getSmsTitle()
  {
    return this.smsTitle;
  }
  
  public void setSmsTitle(String smsTitle)
  {
    this.smsTitle = smsTitle;
  }
  
  public String getSmsCnt()
  {
    return this.smsCnt;
  }
  
  public void setSmsCnt(String smsCnt)
  {
    this.smsCnt = smsCnt;
  }
  
  public String getSmsTemplate()
  {
    return this.smsTemplate;
  }
  
  public void setSmsTemplate(String smsTemplate)
  {
    this.smsTemplate = smsTemplate;
  }
  
  public Integer getSmsStatus()
  {
    return this.smsStatus;
  }
  
  public void setSmsStatus(Integer smsStatus)
  {
    this.smsStatus = smsStatus;
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
 * Qualified Name:     com.xc.pojo.SiteSmsLog
 * JD-Core Version:    0.7.0.1
 */