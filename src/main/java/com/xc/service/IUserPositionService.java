package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.UserPosition;
import com.xc.vo.position.PositionProfitVO;
import com.xc.vo.position.PositionVO;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

public abstract interface IUserPositionService
{
  public abstract ServerResponse buy(Integer stockId, Integer buyNum, Integer buyType, Integer lever, HttpServletRequest paramHttpServletRequest)
    throws Exception;
  
  public abstract ServerResponse sell(String paramString, int paramInt)
    throws Exception;
  
  public abstract ServerResponse lock(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  public abstract ServerResponse del(Integer paramInteger);
  
  public abstract ServerResponse<PageInfo> findMyPositionByCodeAndSpell(String paramString1, String paramString2, Integer paramInteger, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract PositionVO findUserPositionAllProfitAndLose(Integer paramInteger);
  
  public abstract List<UserPosition> findPositionByUserIdAndSellIdIsNull(Integer paramInteger);
  
  public abstract List<UserPosition> findPositionByStockCodeAndTimes(int paramInt, String paramString, Integer paramInteger);
  
  public abstract Integer findPositionNumByTimes(int paramInt, Integer paramInteger);
  
  public abstract ServerResponse listByAgent(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, String paramString1, String paramString2, String paramString3, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract ServerResponse getIncome(Integer paramInteger1, Integer paramInteger2, String paramString1, String paramString2);
  
  public abstract ServerResponse listByAdmin(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract int CountPositionNum(Integer paramInteger1, Integer paramInteger2);
  
  public abstract BigDecimal CountPositionProfitAndLose();
  
  public abstract BigDecimal CountPositionAllProfitAndLose();
  
  public abstract ServerResponse create(Integer paramInteger1, String paramString1, String paramString2, String paramString3, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4);
  
  public abstract int deleteByUserId(Integer paramInteger);
  
  public abstract void doClosingStayTask();
  
  public abstract void expireStayUnwindTask();
  
  public abstract ServerResponse closingStayTask(UserPosition paramUserPosition, Integer paramInteger)
    throws Exception;
  
  public abstract List<Integer> findDistinctUserIdList();
  
  public abstract ServerResponse<PageInfo> findPositionTopList(Integer paramInteger);
  
  public abstract ServerResponse findUserPositionByCode(HttpServletRequest paramHttpServletRequest, String paramString);
  
  public abstract ServerResponse addmargin(String paramString, int paramInt, BigDecimal paramBigDecimal)
    throws Exception;
  
  public abstract PositionProfitVO getPositionProfitVO(UserPosition paramUserPosition);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IUserPositionService

 * JD-Core Version:    0.7.0.1

 */