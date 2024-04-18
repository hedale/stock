package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.FundsTradingAccount;

import javax.servlet.http.HttpServletRequest;

public abstract interface IFundsTradingAccountService
{
  public abstract int insert(FundsTradingAccount paramFundsTradingAccount);
  
  public abstract int update(FundsTradingAccount paramFundsTradingAccount);
  
  public abstract ServerResponse save(FundsTradingAccount paramFundsTradingAccount);
  
  public abstract ServerResponse<PageInfo> getList(int paramInt1, int paramInt2, String paramString, Integer paramInteger, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse getDetail(int paramInt);
  
  public abstract ServerResponse getMaxNumber();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IFundsTradingAccountService

 * JD-Core Version:    0.7.0.1

 */