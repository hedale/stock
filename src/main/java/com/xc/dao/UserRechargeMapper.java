package com.xc.dao;

import com.xc.pojo.UserRecharge;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract interface UserRechargeMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(UserRecharge paramUserRecharge);
  
  public abstract int insertSelective(UserRecharge paramUserRecharge);
  
  public abstract UserRecharge selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(UserRecharge paramUserRecharge);
  
  public abstract int updateByPrimaryKey(UserRecharge paramUserRecharge);
  
  public abstract int checkInMoney(@Param("status") int paramInt, @Param("userId") Integer paramInteger);
  
  public abstract UserRecharge findUserRechargeByOrderSn(String paramString);
  
  public abstract List findUserChargeList(@Param("uid") Integer paramInteger, @Param("payChannel") String paramString1, @Param("orderStatus") String paramString2);
  
  public abstract List listByAdmin(@Param("agentId") Integer paramInteger1, @Param("userId") Integer paramInteger2, @Param("realName") String paramString, @Param("state") Integer paramInteger3, @Param("begin_time") Date paramDate1, @Param("end_time") Date paramDate2);
  
  public abstract int deleteByUserId(@Param("userId") Integer paramInteger);
  
  public abstract List listByAgent(@Param("searchId") Integer paramInteger1, @Param("realName") String paramString1, @Param("payChannel") String paramString2, @Param("state") Integer paramInteger2);
  
  public abstract BigDecimal CountChargeSumAmt(Integer paramInteger);
  
  public abstract BigDecimal CountTotalRechargeAmountByTime(Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.UserRechargeMapper

 * JD-Core Version:    0.7.0.1

 */