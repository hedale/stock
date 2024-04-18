package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.AgentAgencyFee;
import com.xc.pojo.AgentUser;

import javax.servlet.http.HttpServletRequest;

public abstract interface IAgentAgencyFeeService
{
  public abstract int insert(AgentAgencyFee paramAgentAgencyFee);
  
  public abstract int update(AgentAgencyFee paramAgentAgencyFee);
  
  public abstract int AgencyFeeIncome(int paramInt, String paramString);
  
  public abstract ServerResponse<PageInfo> getAgentAgencyFeeList(int paramInt1, int paramInt2, HttpServletRequest paramHttpServletRequest);
  
  public abstract AgentUser getCurrentAgent(HttpServletRequest paramHttpServletRequest);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IAgentAgencyFeeService

 * JD-Core Version:    0.7.0.1

 */