package com.xc.dao;

import com.xc.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

public abstract interface UserMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(User paramUser);
  
  public abstract int insertSelective(User paramUser);
  
  public abstract User selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(User paramUser);
  
  public abstract int updateByPrimaryKey(User paramUser);
  
  public abstract User findByPhone(String paramString);
  
  public abstract User login(@Param("phone") String paramString1, @Param("userPwd") String paramString2);
  
  public abstract List listByAgent(@Param("realName") String paramString1, @Param("phone") String paramString2, @Param("searchId") Integer paramInteger1, @Param("accountType") Integer paramInteger2);
  
  public abstract List listByAdmin(@Param("realName") String paramString1, @Param("phone") String paramString2, @Param("searchId") Integer paramInteger1, @Param("accountType") Integer paramInteger2);
  
  public abstract int CountUserSize(Integer paramInteger);
  
  public abstract BigDecimal CountUserAmt(Integer paramInteger);
  
  public abstract BigDecimal CountEnableAmt(Integer paramInteger);
  
  @Select({"select with_pwd from `user` where with_pwd=#{with_pwd}"})
  public abstract String findWithPwd(String paramString);
  
  @Select({"select with_pwd from `user` where phone=#{phone}"})
  public abstract String findIdWithPwd(String paramString);
  
  @Update({"update `user` set with_pwd=#{with_pwd} where phone=#{phone}"})
  public abstract int updateWithPwd(@Param("with_pwd") String paramString1, @Param("phone") String paramString2);
  
  public abstract int updateUserAmt(@Param("user_amt") Double paramDouble, @Param("user_id") Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.UserMapper

 * JD-Core Version:    0.7.0.1

 */