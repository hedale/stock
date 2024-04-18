package com.xc.controller.agent;

import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.service.IUserRechargeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/agent/recharge/"})
public class AgentRechargeController
{
  private static final Logger log = LoggerFactory.getLogger(AgentRechargeController.class);
  @Autowired
  IUserRechargeService iUserRechargeService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse<PageInfo> list(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize, @RequestParam(value="realName", required=false) String realName, @RequestParam(value="payChannel", required=false) String payChannel, @RequestParam(value="state", required=false) Integer state, @RequestParam(value="agentId", required=false) Integer agentId, HttpServletRequest request)
  {
    return this.iUserRechargeService.listByAgent(agentId, realName, payChannel, state, request, pageNum, pageSize);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.agent.AgentRechargeController

 * JD-Core Version:    0.7.0.1

 */