package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.UserFundsPosition;

import javax.servlet.http.HttpServletRequest;

public abstract interface IUserFundsPositionService
{
  public abstract ServerResponse insert(UserFundsPosition paramUserFundsPosition, HttpServletRequest paramHttpServletRequest);
  
  public abstract int update(UserFundsPosition paramUserFundsPosition);
  
  public abstract ServerResponse save(UserFundsPosition paramUserFundsPosition);
  
  public abstract ServerResponse<PageInfo> getList(int paramInt1, int paramInt2, String paramString, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse getDetail(int paramInt);
  
  public abstract ServerResponse buyFunds(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, HttpServletRequest paramHttpServletRequest)
    throws Exception;
  
  public abstract ServerResponse sellFunds(String paramString, int paramInt)
    throws Exception;
  
  public abstract ServerResponse<PageInfo> findMyPositionByCodeAndSpell(String paramString1, String paramString2, Integer paramInteger, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract ServerResponse findUserFundsPositionByCode(HttpServletRequest paramHttpServletRequest, String paramString);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IUserFundsPositionService

 * JD-Core Version:    0.7.0.1

 */