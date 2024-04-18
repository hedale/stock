package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public abstract interface IUserWithdrawService
{
  public abstract ServerResponse outMoney(String paramString1, String paramString2, HttpServletRequest paramHttpServletRequest)
    throws Exception;
  
  public abstract ServerResponse<PageInfo> findUserWithList(String paramString, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract ServerResponse userCancel(Integer paramInteger);
  
  public abstract ServerResponse listByAgent(Integer paramInteger1, String paramString, Integer paramInteger2, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract ServerResponse<PageInfo> listByAdmin(Integer paramInteger1, Integer paramInteger2, String paramString1, Integer paramInteger3, String paramString2, String paramString3, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract ServerResponse updateState(Integer paramInteger1, Integer paramInteger2, String paramString)
    throws Exception;
  
  public abstract int deleteByUserId(Integer paramInteger);
  
  public abstract BigDecimal CountSpWithSumAmtByState(Integer paramInteger);
  
  public abstract BigDecimal CountSpWithSumAmTodaytByState(Integer paramInteger);
  
  public abstract ServerResponse deleteWithdraw(Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IUserWithdrawService

 * JD-Core Version:    0.7.0.1

 */