package com.xc.dao;

import com.xc.pojo.UserCashDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface UserCashDetailMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(UserCashDetail paramUserCashDetail);
  
  public abstract int insertSelective(UserCashDetail paramUserCashDetail);
  
  public abstract UserCashDetail selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(UserCashDetail paramUserCashDetail);
  
  public abstract int updateByPrimaryKey(UserCashDetail paramUserCashDetail);
  
  public abstract List findUserCashDetailList(@Param("uid") Integer paramInteger1, @Param("positionId") Integer paramInteger2);
  
  public abstract List listByAgent(@Param("userId") Integer paramInteger1, @Param("userName") String paramString, @Param("searchId") Integer paramInteger2, @Param("positionId") Integer paramInteger3);
  
  public abstract List listByAdmin(@Param("userId") Integer paramInteger1, @Param("userName") String paramString, @Param("agentId") Integer paramInteger2, @Param("positionId") Integer paramInteger3);
  
  public abstract int deleteByUserId(@Param("userId") Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.UserCashDetailMapper

 * JD-Core Version:    0.7.0.1

 */