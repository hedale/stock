package com.xc.dao;

import com.xc.pojo.AgentAgencyFee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public abstract interface AgentAgencyFeeMapper
{
  public abstract int insert(AgentAgencyFee paramAgentAgencyFee);
  
  public abstract int delete(int paramInt);
  
  public abstract int update(AgentAgencyFee paramAgentAgencyFee);
  
  public abstract AgentAgencyFee load(int paramInt);
  
  public abstract List<AgentAgencyFee> pageList(int paramInt1, int paramInt2);
  
  public abstract int pageListCount(int paramInt1, int paramInt2);
  
  public abstract List getAgentAgencyFeeList(Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.AgentAgencyFeeMapper

 * JD-Core Version:    0.7.0.1

 */