package com.xc.controller.agent;

import com.xc.common.ServerResponse;
import com.xc.service.IAgentUserService;
import com.xc.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/agent/user/"})
public class AgentUserController
{
  private static final Logger log = LoggerFactory.getLogger(AgentUserController.class);
  @Autowired
  IUserService iUserService;
  @Autowired
  IAgentUserService iAgentUserService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse list(@RequestParam(value="realName", required=false) String realName, @RequestParam(value="phone", required=false) String phone, @RequestParam(value="agentId", required=false) Integer agentId, @RequestParam(value="accountType", required=false) Integer accountType, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="12") int pageSize, HttpServletRequest request)
  {
    return this.iUserService.listByAgent(realName, phone, agentId, accountType, pageNum, pageSize, request);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.agent.AgentUserController

 * JD-Core Version:    0.7.0.1

 */