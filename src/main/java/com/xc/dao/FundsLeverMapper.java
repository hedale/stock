package com.xc.dao;

import com.xc.pojo.FundsLever;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public abstract interface FundsLeverMapper
{
  public abstract int insert(FundsLever paramFundsLever);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(FundsLever paramFundsLever);
  
  public abstract FundsLever load(int paramInt);
  
  public abstract List<FundsLever> pageList(int paramInt1, int paramInt2);
  
  public abstract int pageListCount(int paramInt1, int paramInt2);
  
  public abstract List<FundsLever> getFundsTypeList(@Param("cycleType") Integer paramInteger);
  
  public abstract FundsLever getLeverRateInfo(@Param("cycleType") Integer paramInteger1, @Param("lever") Integer paramInteger2);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.FundsLeverMapper

 * JD-Core Version:    0.7.0.1

 */