package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.FundsLever;

import javax.servlet.http.HttpServletRequest;

public abstract interface IFundsLeverService
{
  public abstract int insert(FundsLever paramFundsLever);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(FundsLever paramFundsLever);
  
  public abstract ServerResponse<PageInfo> getFundsLeverList(int paramInt1, int paramInt2, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse saveFundsLever(FundsLever paramFundsLever);
  
  public abstract ServerResponse getFundsTypeList(Integer paramInteger);
  
  public abstract ServerResponse getLeverRateInfo(Integer paramInteger1, Integer paramInteger2);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IFundsLeverService

 * JD-Core Version:    0.7.0.1

 */