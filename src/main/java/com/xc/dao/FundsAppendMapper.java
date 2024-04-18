package com.xc.dao;

import com.xc.pojo.FundsAppend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public abstract interface FundsAppendMapper
{
  public abstract int insert(FundsAppend paramFundsAppend);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(FundsAppend paramFundsAppend);
  
  public abstract FundsAppend load(int paramInt);
  
  public abstract List<FundsAppend> pageList(@Param("pageNum") int paramInt1, @Param("pageSize") int paramInt2, @Param("keyword") String paramString, @Param("status") Integer paramInteger1, @Param("userId") Integer paramInteger2, @Param("appendType") Integer paramInteger3);
  
  public abstract int pageListCount(int paramInt1, int paramInt2);
  
  public abstract int isAppendEnd(@Param("applyId") Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.FundsAppendMapper

 * JD-Core Version:    0.7.0.1

 */