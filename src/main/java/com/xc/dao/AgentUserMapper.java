package com.xc.dao;

import com.xc.pojo.AgentUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface AgentUserMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(AgentUser paramAgentUser);
  
  public abstract int insertSelective(AgentUser paramAgentUser);
  
  public abstract AgentUser selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(AgentUser paramAgentUser);
  
  public abstract int updateByPrimaryKey(AgentUser paramAgentUser);
  
  public abstract int updateTotalMoney(AgentUser paramAgentUser);
  
  public abstract AgentUser findByCode(String paramString);
  
  public abstract AgentUser findByPhone(String paramString);
  
  public abstract AgentUser findByName(String paramString);
  
  public abstract AgentUser login(@Param("agentPhone") String paramString1, @Param("agentPwd") String paramString2);
  
  public abstract List getSecondAgent(Integer paramInteger);
  
  public abstract List listByAdmin(@Param("realName") String paramString1, @Param("phone") String paramString2, @Param("id") int paramInt);
  
  public abstract int CountAgentNum();
  
  public abstract List getAgentSuperiorList(@Param("agentId") int paramInt);
  
  public abstract AgentUser findAgentByAgentId(@Param("agentId") int paramInt);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.AgentUserMapper

 * JD-Core Version:    0.7.0.1

 */