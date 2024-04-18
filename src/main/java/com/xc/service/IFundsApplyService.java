package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.FundsApply;

import javax.servlet.http.HttpServletRequest;

public abstract interface IFundsApplyService
{
  public abstract ServerResponse insert(FundsApply paramFundsApply, HttpServletRequest paramHttpServletRequest)
    throws Exception;
  
  public abstract int update(FundsApply paramFundsApply);
  
  public abstract ServerResponse save(FundsApply paramFundsApply);
  
  public abstract ServerResponse<PageInfo> getList(int paramInt1, int paramInt2, String paramString, Integer paramInteger, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse getDetail(int paramInt);
  
  public abstract ServerResponse<PageInfo> getUserApplyList(int paramInt1, int paramInt2, int paramInt3, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse audit(FundsApply paramFundsApply, HttpServletRequest paramHttpServletRequest)
    throws Exception;
  
  public abstract ServerResponse<PageInfo> getUserEnabledSubaccount(HttpServletRequest paramHttpServletRequest);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IFundsApplyService

 * JD-Core Version:    0.7.0.1

 */