package com.xc.controller.agent;

import com.xc.common.ServerResponse;
import com.xc.service.IUserWithdrawService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/agent/withdraw/"})
public class AgentWithdrawController
{
  private static final Logger log = LoggerFactory.getLogger(AgentWithdrawController.class);
  @Autowired
  IUserWithdrawService iUserWithdrawService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse list(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="8") int pageSize, @RequestParam(value="realName", required=false) String realName, @RequestParam(value="state", required=false) Integer state, @RequestParam(value="agentId", required=false) Integer agentId, HttpServletRequest request)
  {
    return this.iUserWithdrawService.listByAgent(agentId, realName, state, request, pageNum, pageSize);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.agent.AgentWithdrawController

 * JD-Core Version:    0.7.0.1

 */