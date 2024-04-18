package com.xc.dao;

import com.xc.pojo.UserBank;

public abstract interface UserBankMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(UserBank paramUserBank);
  
  public abstract int insertSelective(UserBank paramUserBank);
  
  public abstract UserBank selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(UserBank paramUserBank);
  
  public abstract int updateByPrimaryKey(UserBank paramUserBank);
  
  public abstract UserBank findUserBankByUserId(Integer paramInteger);
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.dao.UserBankMapper
 * JD-Core Version:    0.7.0.1
 */