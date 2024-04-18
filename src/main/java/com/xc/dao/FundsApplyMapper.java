package com.xc.dao;

import com.xc.pojo.FundsApply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public abstract interface FundsApplyMapper
{
  public abstract int insert(FundsApply paramFundsApply);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(FundsApply paramFundsApply);
  
  public abstract FundsApply load(int paramInt);
  
  public abstract List<FundsApply> pageList(@Param("pageNum") int paramInt1, @Param("pageSize") int paramInt2, @Param("keyword") String paramString, @Param("status") Integer paramInteger);
  
  public abstract int pageListCount(int paramInt1, int paramInt2);
  
  public abstract List<FundsApply> getUserApplyList(@Param("pageNum") int paramInt1, @Param("pageSize") int paramInt2, @Param("userId") int paramInt3);
  
  public abstract List<FundsApply> getUserEnabledSubaccount(@Param("userId") int paramInt);
  
  public abstract List<FundsApply> getUserMarginList(@Param("userId") int paramInt);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.FundsApplyMapper

 * JD-Core Version:    0.7.0.1

 */