package com.xc.service;

import com.xc.common.ServerResponse;
import com.xc.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public abstract interface IUserService
{
  public abstract ServerResponse reg(String paramString1, String paramString2, String paramString3, String paramString4, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse login(String paramString1, String paramString2, HttpServletRequest paramHttpServletRequest);
  
  public abstract User getCurrentUser(HttpServletRequest paramHttpServletRequest);
  
  public abstract User getCurrentRefreshUser(HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse addOption(String paramString, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse delOption(String paramString, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse isOption(String paramString, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse getUserInfo(HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse updatePwd(String paramString1, String paramString2, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse checkPhone(String paramString);
  
  public abstract ServerResponse updatePwd(String paramString1, String paramString2, String paramString3);
  
  public abstract ServerResponse update(User paramUser);
  
  public abstract ServerResponse auth(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse transAmt(Integer paramInteger1, Integer paramInteger2, HttpServletRequest paramHttpServletRequest);
  
  public abstract void ForceSellTask();
  
  public abstract void ForceSellOneStockTask();
  
  public abstract void ForceSellMessageTask();
  
  public abstract void ForceSellIndexTask();
  
  public abstract void ForceSellIndexsMessageTask();
  
  public abstract void ForceSellFuturesTask();
  
  public abstract void ForceSellFuturesMessageTask();
  
  public abstract void qh1();
  
  public abstract void zs1();
  
  public abstract ServerResponse listByAgent(String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2, int paramInt1, int paramInt2, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse addSimulatedAccount(Integer paramInteger1, String paramString1, String paramString2, String paramString3, Integer paramInteger2, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse listByAdmin(String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2, int paramInt1, int paramInt2, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse findByUserId(Integer paramInteger);
  
  public abstract ServerResponse updateLock(Integer paramInteger);
  
  public abstract ServerResponse updateAmt(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);
  
  public abstract ServerResponse delete(Integer paramInteger, HttpServletRequest paramHttpServletRequest);
  
  public abstract int CountUserSize(Integer paramInteger);
  
  public abstract BigDecimal CountUserAmt(Integer paramInteger);
  
  public abstract BigDecimal CountEnableAmt(Integer paramInteger);
  
  public abstract ServerResponse authByAdmin(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  public abstract ServerResponse findIdWithPwd(String paramString);
  
  public abstract ServerResponse updateWithPwd(String paramString1, String paramString2);
  
  public abstract void updateUserAmt(Double paramDouble, Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IUserService

 * JD-Core Version:    0.7.0.1

 */