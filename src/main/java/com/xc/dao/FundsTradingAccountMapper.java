package com.xc.dao;

import com.xc.pojo.FundsTradingAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public abstract interface FundsTradingAccountMapper
{
  public abstract int insert(FundsTradingAccount paramFundsTradingAccount);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(FundsTradingAccount paramFundsTradingAccount);
  
  public abstract FundsTradingAccount load(int paramInt);
  
  public abstract int pageListCount(int paramInt1, int paramInt2);
  
  public abstract List<FundsTradingAccount> pageList(@Param("pageNum") int paramInt1, @Param("pageSize") int paramInt2, @Param("keyword") String paramString, @Param("status") Integer paramInteger);
  
  public abstract int getMaxNumber();
  
  public abstract FundsTradingAccount getAccountByNumber(@Param("subaccountNumber") Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.FundsTradingAccountMapper

 * JD-Core Version:    0.7.0.1

 */