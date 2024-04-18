package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.FundsDealerInstitutions;

import javax.servlet.http.HttpServletRequest;

public abstract interface IFundsDealerInstitutionsService
{
  public abstract int insert(FundsDealerInstitutions paramFundsDealerInstitutions);
  
  public abstract int update(FundsDealerInstitutions paramFundsDealerInstitutions);
  
  public abstract ServerResponse save(FundsDealerInstitutions paramFundsDealerInstitutions);
  
  public abstract ServerResponse<PageInfo> getList(int paramInt1, int paramInt2, String paramString, Integer paramInteger, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse getDetail(int paramInt);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IFundsDealerInstitutionsService

 * JD-Core Version:    0.7.0.1

 */