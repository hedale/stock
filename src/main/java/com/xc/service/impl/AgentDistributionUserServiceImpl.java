package com.xc.service.impl;

import com.xc.dao.AgentDistributionUserMapper;
import com.xc.pojo.AgentDistributionUser;
import com.xc.service.IAgentDistributionUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("IAgentDistributionUserService")
public class AgentDistributionUserServiceImpl
  implements IAgentDistributionUserService
{
  @Resource
  private AgentDistributionUserMapper agentDistributionUserMapper;
  
  public int insert(AgentDistributionUser agentDistributionUser)
  {
    int ret = 0;
    if (agentDistributionUser == null) {
      return 0;
    }
    ret = this.agentDistributionUserMapper.insert(agentDistributionUser);
    return ret;
  }
  
  public int update(AgentDistributionUser agentDistributionUser)
  {
    int ret = this.agentDistributionUserMapper.update(agentDistributionUser);
    return ret > 0 ? ret : 0;
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.AgentDistributionUserServiceImpl

 * JD-Core Version:    0.7.0.1

 */