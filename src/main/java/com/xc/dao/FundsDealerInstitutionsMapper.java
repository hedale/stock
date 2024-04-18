package com.xc.dao;

import com.xc.pojo.FundsDealerInstitutions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public abstract interface FundsDealerInstitutionsMapper
{
  public abstract int insert(FundsDealerInstitutions paramFundsDealerInstitutions);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(FundsDealerInstitutions paramFundsDealerInstitutions);
  
  public abstract FundsDealerInstitutions load(int paramInt);
  
  public abstract List<FundsDealerInstitutions> pageList(@Param("pageNum") int paramInt1, @Param("pageSize") int paramInt2, @Param("keyword") String paramString, @Param("status") Integer paramInteger);
  
  public abstract int pageListCount(int paramInt1, int paramInt2);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.FundsDealerInstitutionsMapper

 * JD-Core Version:    0.7.0.1

 */