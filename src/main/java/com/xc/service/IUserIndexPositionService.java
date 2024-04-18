package com.xc.service;

import com.xc.common.ServerResponse;
import com.xc.pojo.UserIndexPosition;
import com.xc.vo.indexposition.IndexPositionVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public abstract interface IUserIndexPositionService
{
  public abstract ServerResponse buyIndex(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, HttpServletRequest paramHttpServletRequest)
    throws Exception;
  
  public abstract ServerResponse del(Integer paramInteger);
  
  public abstract ServerResponse sellIndex(String paramString, int paramInt)
    throws Exception;
  
  public abstract ServerResponse lock(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  public abstract ServerResponse listByAgent(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, String paramString1, String paramString2, String paramString3, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract ServerResponse listByAdmin(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract ServerResponse findMyIndexPositionByNameAndCode(String paramString1, String paramString2, Integer paramInteger, HttpServletRequest paramHttpServletRequest, int paramInt1, int paramInt2);
  
  public abstract IndexPositionVO findUserIndexPositionAllProfitAndLose(Integer paramInteger);
  
  public abstract List<Integer> findDistinctUserIdList();
  
  public abstract List<UserIndexPosition> findIndexPositionByUserIdAndSellPriceIsNull(Integer paramInteger);
  
  public abstract ServerResponse getIndexIncome(Integer paramInteger1, Integer paramInteger2, String paramString1, String paramString2);
  
  public abstract ServerResponse findUserIndexPositionByCode(HttpServletRequest paramHttpServletRequest, String paramString);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IUserIndexPositionService

 * JD-Core Version:    0.7.0.1

 */