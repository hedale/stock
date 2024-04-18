package com.xc.dao;

import com.xc.pojo.UserIndexPosition;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public abstract interface UserIndexPositionMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(UserIndexPosition paramUserIndexPosition);
  
  public abstract int insertSelective(UserIndexPosition paramUserIndexPosition);
  
  public abstract UserIndexPosition selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(UserIndexPosition paramUserIndexPosition);
  
  public abstract int updateByPrimaryKey(UserIndexPosition paramUserIndexPosition);
  
  public abstract UserIndexPosition selectIndexPositionBySn(String paramString);
  
  public abstract List findMyIndexPositionByNameAndCode(@Param("userId") Integer paramInteger1, @Param("indexName") String paramString1, @Param("indexCode") String paramString2, @Param("state") Integer paramInteger2);
  
  public abstract List listByAdmin(@Param("positionType") Integer paramInteger1, @Param("state") Integer paramInteger2, @Param("userId") Integer paramInteger3, @Param("searchId") Integer paramInteger4, @Param("positionSn") String paramString, @Param("beginTime") Date paramDate1, @Param("endTime") Date paramDate2);
  
  public abstract List listByAgent(@Param("positionType") Integer paramInteger1, @Param("state") Integer paramInteger2, @Param("userId") Integer paramInteger3, @Param("searchId") Integer paramInteger4, @Param("positionSn") String paramString, @Param("beginTime") Date paramDate1, @Param("endTime") Date paramDate2);
  
  public abstract List findPositionByUserIdAndSellPriceIsNull(Integer paramInteger);
  
  public abstract List findDistinctUserIdList();
  
  public abstract UserIndexPosition findUserIndexPositionByCode(@Param("userId") Integer paramInteger, @Param("indexGid") String paramString);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.UserIndexPositionMapper

 * JD-Core Version:    0.7.0.1

 */