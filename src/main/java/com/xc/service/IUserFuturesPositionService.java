package com.xc.service;

import com.xc.common.ServerResponse;
import com.xc.pojo.UserFuturesPosition;
import com.xc.vo.futuresposition.FuturesPositionVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public abstract interface IUserFuturesPositionService
{
  public abstract ServerResponse buyFutures(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, HttpServletRequest paramHttpServletRequest)
    throws Exception;
  
  public abstract ServerResponse del(Integer paramInteger);
  
  public abstract ServerResponse sellFutures(String paramString, int paramInt)
    throws Exception;
  
  public abstract ServerResponse listByAdmin(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract ServerResponse lock(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  public abstract ServerResponse findMyFuturesPositionByNameAndCode(String paramString1, String paramString2, Integer paramInteger, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract ServerResponse listByAgent(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, String paramString1, String paramString2, String paramString3, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract List<UserFuturesPosition> findPositionByFuturesCodeAndTimes(int paramInt, String paramString, Integer paramInteger);
  
  public abstract Integer findPositionNumByTimes(int paramInt, Integer paramInteger);
  
  public abstract List<Integer> findDistinctUserIdList();
  
  public abstract List<UserFuturesPosition> findFuturesPositionByUserIdAndSellPriceIsNull(Integer paramInteger);
  
  public abstract FuturesPositionVO findUserFuturesPositionAllProfitAndLose(Integer paramInteger);
  
  public abstract ServerResponse getFuturesIncome(Integer paramInteger1, Integer paramInteger2, String paramString1, String paramString2);
  
  public abstract ServerResponse findUserFuturesPositionByCode(HttpServletRequest paramHttpServletRequest, String paramString);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IUserFuturesPositionService

 * JD-Core Version:    0.7.0.1

 */