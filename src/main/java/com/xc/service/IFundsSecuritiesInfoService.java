package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.FundsSecuritiesInfo;

import javax.servlet.http.HttpServletRequest;

public abstract interface IFundsSecuritiesInfoService
{
  public abstract int insert(FundsSecuritiesInfo paramFundsSecuritiesInfo);
  
  public abstract int update(FundsSecuritiesInfo paramFundsSecuritiesInfo);
  
  public abstract ServerResponse save(FundsSecuritiesInfo paramFundsSecuritiesInfo);
  
  public abstract ServerResponse<PageInfo> getList(int paramInt1, int paramInt2, String paramString, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse getDetail(int paramInt);
  
  public abstract ServerResponse<PageInfo> getEnabledList();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IFundsSecuritiesInfoService

 * JD-Core Version:    0.7.0.1

 */