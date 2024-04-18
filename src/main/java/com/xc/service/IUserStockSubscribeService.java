package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.UserStockSubscribe;

import javax.servlet.http.HttpServletRequest;

public abstract interface IUserStockSubscribeService
{
  public abstract int insert(UserStockSubscribe paramUserStockSubscribe);
  
  public abstract int update(UserStockSubscribe paramUserStockSubscribe);
  
  public abstract ServerResponse save(UserStockSubscribe paramUserStockSubscribe, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse sendMsg(UserStockSubscribe paramUserStockSubscribe, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse<PageInfo> getList(int paramInt1, int paramInt2, String paramString, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse getDetail(int paramInt);
  
  public abstract ServerResponse getOneSubscribeByUserId(Integer paramInteger, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse userSubmit(UserStockSubscribe paramUserStockSubscribe, HttpServletRequest paramHttpServletRequest);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IUserStockSubscribeService

 * JD-Core Version:    0.7.0.1

 */