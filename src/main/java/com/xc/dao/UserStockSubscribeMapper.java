package com.xc.dao;

import com.xc.pojo.UserStockSubscribe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public abstract interface UserStockSubscribeMapper
{
  public abstract int insert(UserStockSubscribe paramUserStockSubscribe);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(UserStockSubscribe paramUserStockSubscribe);
  
  public abstract UserStockSubscribe load(int paramInt);
  
  public abstract List<UserStockSubscribe> pageList(@Param("pageNum") int paramInt1, @Param("pageSize") int paramInt2, @Param("keyword") String paramString);
  
  public abstract int pageListCount(int paramInt1, int paramInt2);
  
  public abstract UserStockSubscribe getOneSubscribeByUserId(Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.UserStockSubscribeMapper

 * JD-Core Version:    0.7.0.1

 */