package com.xc.service;

import com.xc.common.ServerResponse;
import com.xc.pojo.FundsSetting;

import javax.servlet.http.HttpServletRequest;

public abstract interface IFundsSettingService
{
  public abstract int insert(FundsSetting paramFundsSetting);
  
  public abstract int update(FundsSetting paramFundsSetting);
  
  public abstract FundsSetting load(int paramInt);
  
  public abstract ServerResponse save(FundsSetting paramFundsSetting, HttpServletRequest paramHttpServletRequest);
  
  public abstract FundsSetting getFundsSetting();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IFundsSettingService

 * JD-Core Version:    0.7.0.1

 */