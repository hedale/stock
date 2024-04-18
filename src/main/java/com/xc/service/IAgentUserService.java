package com.xc.service;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.pojo.AgentUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public abstract interface IAgentUserService
{
  public abstract AgentUser getCurrentAgent(HttpServletRequest paramHttpServletRequest);
  
  public abstract AgentUser findByCode(String paramString);
  
  public abstract ServerResponse login(String paramString1, String paramString2, String paramString3, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse getAgentInfo(HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse updatePwd(String paramString1, String paramString2, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse addAgentUser(String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger, String paramString5, String paramString6, String paramString7, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse<PageInfo> getSecondAgent(int paramInt1, int paramInt2, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse<PageInfo> listByAdmin(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse add(AgentUser paramAgentUser, HttpServletRequest paramHttpServletRequest);
  
  public abstract ServerResponse update(AgentUser paramAgentUser);
  
  public abstract int CountAgentNum();
  
  public abstract List<AgentUser> getAgentSuperiorList(int paramInt);
  
  public abstract ServerResponse updateAgentAmt(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);
  
  public abstract ServerResponse delAgent(Integer paramInteger);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.IAgentUserService

 * JD-Core Version:    0.7.0.1

 */