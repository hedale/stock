package com.xc.dao;

import com.xc.pojo.UserPosition;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract interface UserPositionMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(UserPosition paramUserPosition);
  
  public abstract int insertSelective(UserPosition paramUserPosition);
  
  public abstract UserPosition selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(UserPosition paramUserPosition);
  
  public abstract int updateByPrimaryKey(UserPosition paramUserPosition);
  
  public abstract UserPosition findPositionBySn(String paramString);
  
  public abstract List findMyPositionByCodeAndSpell(@Param("uid") Integer paramInteger1, @Param("stockCode") String paramString1, @Param("stockSpell") String paramString2, @Param("state") Integer paramInteger2);
  
  public abstract List findPositionByUserIdAndSellIdIsNull(Integer paramInteger);
  
  public abstract List listByAgent(@Param("positionType") Integer paramInteger1, @Param("state") Integer paramInteger2, @Param("userId") Integer paramInteger3, @Param("searchId") Integer paramInteger4, @Param("positionSn") String paramString, @Param("beginTime") Date paramDate1, @Param("endTime") Date paramDate2);
  
  public abstract List findAllStayPosition();
  
  public abstract List findDistinctUserIdList();
  
  public abstract int CountPositionNum(@Param("state") Integer paramInteger1, @Param("accountType") Integer paramInteger2);
  
  public abstract BigDecimal CountPositionProfitAndLose();
  
  public abstract BigDecimal CountPositionAllProfitAndLose();
  
  public abstract int deleteByUserId(@Param("userId") Integer paramInteger);
  
  public abstract List findPositionByStockCodeAndTimes(@Param("minuteTimes") Date paramDate, @Param("stockCode") String paramString, @Param("userId") Integer paramInteger);
  
  public abstract Integer findPositionNumByTimes(@Param("beginDate") Date paramDate, @Param("userId") Integer paramInteger);
  
  public abstract List findPositionTopList(@Param("pageSize") Integer paramInteger);
  
  public abstract UserPosition findUserPositionByCode(@Param("userId") Integer paramInteger, @Param("stockCode") String paramString);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.UserPositionMapper

 * JD-Core Version:    0.7.0.1

 */