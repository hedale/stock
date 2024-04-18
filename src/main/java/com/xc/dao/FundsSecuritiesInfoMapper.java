package com.xc.dao;

import com.xc.pojo.FundsSecuritiesInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public abstract interface FundsSecuritiesInfoMapper
{
  public abstract int insert(FundsSecuritiesInfo paramFundsSecuritiesInfo);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(FundsSecuritiesInfo paramFundsSecuritiesInfo);
  
  public abstract FundsSecuritiesInfo load(int paramInt);
  
  public abstract List<FundsSecuritiesInfo> pageList(@Param("pageNum") int paramInt1, @Param("pageSize") int paramInt2, @Param("keyword") String paramString);
  
  public abstract int pageListCount(int paramInt1, int paramInt2);
  
  public abstract List<FundsSecuritiesInfo> getEnabledList();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.FundsSecuritiesInfoMapper

 * JD-Core Version:    0.7.0.1

 */