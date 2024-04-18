package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;

public abstract interface ISiteAmtTransLogService
{
  public abstract ServerResponse<PageInfo> transList(Integer paramInteger, String paramString, int paramInt1, int paramInt2);
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.service.ISiteAmtTransLogService
 * JD-Core Version:    0.7.0.1
 */