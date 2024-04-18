package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.UserRecharge;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public abstract interface IUserRechargeService
{
  public abstract ServerResponse checkInMoney(int paramInt, Integer paramInteger);
  
  public abstract ServerResponse inMoney(String paramString1, String paramString2, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse findUserRechargeByOrderSn(String paramString);
  
  public abstract ServerResponse chargeSuccess(UserRecharge paramUserRecharge)
    throws Exception;
  
  public abstract ServerResponse chargeFail(UserRecharge paramUserRecharge)
    throws Exception;
  
  public abstract ServerResponse chargeCancel(UserRecharge paramUserRecharge)
    throws Exception;
  
  public abstract ServerResponse<PageInfo> findUserChargeList(String paramString1, String paramString2, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract ServerResponse<PageInfo> listByAgent(Integer paramInteger1, String paramString1, String paramString2, Integer paramInteger2, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract ServerResponse listByAdmin(Integer paramInteger1, Integer paramInteger2, String paramString1, Integer paramInteger3, String paramString2, String paramString3, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract ServerResponse updateState(Integer paramInteger1, Integer paramInteger2)
    throws Exception;
  
  public abstract ServerResponse createOrder(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString);
  
  public abstract ServerResponse del(Integer paramInteger);
  
  public abstract int deleteByUserId(Integer paramInteger);
  
  public abstract BigDecimal CountChargeSumAmt(Integer paramInteger);
  
  public abstract BigDecimal CountTotalRechargeAmountByTime(Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IUserRechargeService

 * JD-Core Version:    0.7.0.1

 */