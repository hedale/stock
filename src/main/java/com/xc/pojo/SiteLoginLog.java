package com.xc.pojo;

import java.util.Date;

public class SiteLoginLog
{
  private Integer id;
  private Integer userId;
  private String userName;
  private String loginIp;
  private String loginAddress;
  private Date addTime;
  
  public SiteLoginLog(Integer id, Integer userId, String userName, String loginIp, String loginAddress, Date addTime)
  {
    this.id = id;
    this.userId = userId;
    this.userName = userName;
    this.loginIp = loginIp;
    this.loginAddress = loginAddress;
    this.addTime = addTime;
  }
  
  public SiteLoginLog() {}
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public Integer getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(Integer userId)
  {
    this.userId = userId;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getLoginIp()
  {
    return this.loginIp;
  }
  
  public void setLoginIp(String loginIp)
  {
    this.loginIp = loginIp;
  }
  
  public String getLoginAddress()
  {
    return this.loginAddress;
  }
  
  public void setLoginAddress(String loginAddress)
  {
    this.loginAddress = loginAddress;
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
 * Qualified Name:     com.xc.pojo.SiteLoginLog
 * JD-Core Version:    0.7.0.1
 */