package com.xc.dao;

import com.xc.pojo.UserFundsPosition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public abstract interface UserFundsPositionMapper
{
  public abstract int insert(UserFundsPosition paramUserFundsPosition);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(UserFundsPosition paramUserFundsPosition);
  
  public abstract UserFundsPosition load(int paramInt);
  
  public abstract List<UserFundsPosition> pageList(@Param("pageNum") int paramInt1, @Param("pageSize") int paramInt2, @Param("keyword") String paramString);
  
  public abstract int pageListCount(int paramInt1, int paramInt2);
  
  public abstract List findMyPositionByCodeAndSpell(@Param("uid") Integer paramInteger1, @Param("stockCode") String paramString1, @Param("stockSpell") String paramString2, @Param("state") Integer paramInteger2);
  
  public abstract UserFundsPosition findPositionBySn(String paramString);
  
  public abstract UserFundsPosition findUserFundsPositionByCode(@Param("userId") Integer paramInteger, @Param("fundsCode") String paramString);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.UserFundsPositionMapper

 * JD-Core Version:    0.7.0.1

 */