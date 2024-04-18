package com.xc.pojo;

import java.util.Date;

public class UserBank
{
  private Integer id;
  private Integer userId;
  private String bankName;
  private String bankNo;
  private String bankAddress;
  private String bankImg;
  private String bankPhone;
  private Date addTime;
  
  public UserBank(Integer id, Integer userId, String bankName, String bankNo, String bankAddress, String bankImg, String bankPhone, Date addTime)
  {
    this.id = id;
    
    this.userId = userId;
    
    this.bankName = bankName;
    
    this.bankNo = bankNo;
    
    this.bankAddress = bankAddress;
    
    this.bankImg = bankImg;
    
    this.bankPhone = bankPhone;
    
    this.addTime = addTime;
  }
  
  public UserBank() {}
  
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
  
  public String getBankName()
  {
    return this.bankName;
  }
  
  public void setBankName(String bankName)
  {
    this.bankName = bankName;
  }
  
  public String getBankNo()
  {
    return this.bankNo;
  }
  
  public void setBankNo(String bankNo)
  {
    this.bankNo = bankNo;
  }
  
  public String getBankAddress()
  {
    return this.bankAddress;
  }
  
  public void setBankAddress(String bankAddress)
  {
    this.bankAddress = bankAddress;
  }
  
  public String getBankImg()
  {
    return this.bankImg;
  }
  
  public void setBankImg(String bankImg)
  {
    this.bankImg = bankImg;
  }
  
  public String getBankPhone()
  {
    return this.bankPhone;
  }
  
  public void setBankPhone(String bankPhone)
  {
    this.bankPhone = bankPhone;
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
 * Qualified Name:     com.xc.pojo.UserBank
 * JD-Core Version:    0.7.0.1
 */