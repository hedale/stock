package com.xc.dao;

import com.xc.pojo.UserWithdraw;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public abstract interface UserWithdrawMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(UserWithdraw paramUserWithdraw);
  
  public abstract int insertSelective(UserWithdraw paramUserWithdraw);
  
  public abstract UserWithdraw selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(UserWithdraw paramUserWithdraw);
  
  public abstract int updateByPrimaryKey(UserWithdraw paramUserWithdraw);
  
  public abstract List findUserWithList(@Param("uid") Integer paramInteger, @Param("withStatus") String paramString);
  
  public abstract List listByAgent(@Param("searchId") Integer paramInteger1, @Param("realName") String paramString, @Param("state") Integer paramInteger2);
  
  public abstract List listByAdmin(@Param("agentId") Integer paramInteger1, @Param("userId") Integer paramInteger2, @Param("realName") String paramString1, @Param("state") Integer paramInteger3, @Param("beginTime") String paramString2, @Param("endTime") String paramString3);
  
  public abstract BigDecimal CountSpWithSumAmtByState(Integer paramInteger);
  
  public abstract BigDecimal CountSpWithSumAmTodaytByState(Integer paramInteger);
  
  public abstract int deleteByUserId(@Param("userId") Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.UserWithdrawMapper

 * JD-Core Version:    0.7.0.1

 */