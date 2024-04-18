package com.xc.dao;

import com.xc.pojo.UserFuturesPosition;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public abstract interface UserFuturesPositionMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(UserFuturesPosition paramUserFuturesPosition);
  
  public abstract int insertSelective(UserFuturesPosition paramUserFuturesPosition);
  
  public abstract UserFuturesPosition selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(UserFuturesPosition paramUserFuturesPosition);
  
  public abstract int updateByPrimaryKey(UserFuturesPosition paramUserFuturesPosition);
  
  public abstract List findMyFuturesPositionByNameAndCode(@Param("userId") Integer paramInteger1, @Param("fuName") String paramString1, @Param("fuCode") String paramString2, @Param("state") Integer paramInteger2);
  
  public abstract List listByAdmin(@Param("positionType") Integer paramInteger1, @Param("state") Integer paramInteger2, @Param("userId") Integer paramInteger3, @Param("searchId") Integer paramInteger4, @Param("positionSn") String paramString, @Param("beginTime") Date paramDate1, @Param("endTime") Date paramDate2);
  
  public abstract List listByAgent(@Param("positionType") Integer paramInteger1, @Param("state") Integer paramInteger2, @Param("userId") Integer paramInteger3, @Param("searchId") Integer paramInteger4, @Param("positionSn") String paramString, @Param("beginTime") Date paramDate1, @Param("endTime") Date paramDate2);
  
  public abstract UserFuturesPosition selectPositionBySn(String paramString);
  
  public abstract List findPositionByFuturesCodeAndTimes(@Param("minuteTimes") Date paramDate, @Param("futuresCode") String paramString, @Param("userId") Integer paramInteger);
  
  public abstract Integer findPositionNumByTimes(@Param("beginDate") Date paramDate, @Param("userId") Integer paramInteger);
  
  public abstract List findDistinctUserIdList();
  
  public abstract List findFuturesPositionByUserIdAndSellPriceIsNull(Integer paramInteger);
  
  public abstract UserFuturesPosition findUserFuturesPositionByCode(@Param("userId") Integer paramInteger, @Param("futuresGid") String paramString);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.UserFuturesPositionMapper

 * JD-Core Version:    0.7.0.1

 */