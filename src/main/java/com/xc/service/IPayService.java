package com.xc.service;

import com.xc.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public abstract interface IPayService
{
  public abstract ServerResponse juhe1(String paramString1, String paramString2, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse juhenewpay(String paramString1, String paramString2, HttpServletRequest paramHttpServletRequest)
    throws Exception;
  
  public abstract ServerResponse juheh5pay(String paramString1, String paramString2, HttpServletRequest paramHttpServletRequest)
    throws Exception;
  
  public abstract ServerResponse juhe1Notify(HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse juhenewpayNotify(HttpServletRequest paramHttpServletRequest)
    throws UnsupportedEncodingException;
  
  public abstract ServerResponse flyPay(String paramString1, String paramString2, String paramString3, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse flyNotify(HttpServletRequest paramHttpServletRequest);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IPayService

 * JD-Core Version:    0.7.0.1

 */