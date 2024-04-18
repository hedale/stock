package com.xc.dao;

import com.xc.pojo.FundsSetting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public abstract interface FundsSettingMapper
{
  public abstract int insert(FundsSetting paramFundsSetting);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(FundsSetting paramFundsSetting);
  
  public abstract FundsSetting load(int paramInt);
  
  public abstract List<FundsSetting> pageList(int paramInt1, int paramInt2);
  
  public abstract int pageListCount(int paramInt1, int paramInt2);
  
  public abstract List findAllFundsSetting();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.FundsSettingMapper

 * JD-Core Version:    0.7.0.1

 */