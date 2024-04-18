package com.xc.dao;

import com.xc.pojo.SiteSpread;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public abstract interface SiteSpreadMapper
{
  public abstract int insert(SiteSpread paramSiteSpread);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(SiteSpread paramSiteSpread);
  
  public abstract SiteSpread load(int paramInt);
  
  public abstract List<SiteSpread> pageList(@Param("pageNum") int paramInt1, @Param("pageSize") int paramInt2, @Param("typeName") String paramString);
  
  public abstract SiteSpread findSpreadRateOne(@Param("applies") BigDecimal paramBigDecimal1, @Param("turnover") BigDecimal paramBigDecimal2, @Param("code") String paramString, @Param("unitprice") BigDecimal paramBigDecimal3);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SiteSpreadMapper

 * JD-Core Version:    0.7.0.1

 */