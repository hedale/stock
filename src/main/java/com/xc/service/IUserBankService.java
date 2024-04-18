package com.xc.service;

import com.xc.common.ServerResponse;
import com.xc.pojo.UserBank;

import javax.servlet.http.HttpServletRequest;

public abstract interface IUserBankService
{
  public abstract UserBank findUserBankByUserId(Integer paramInteger);
  
  public abstract ServerResponse addBank(UserBank paramUserBank, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse updateBank(UserBank paramUserBank, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse getBankInfo(HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse updateBankByAdmin(UserBank paramUserBank);
  
  public abstract ServerResponse getBank(Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IUserBankService

 * JD-Core Version:    0.7.0.1

 */