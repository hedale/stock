package com.xc.controller.agent;

import com.xc.common.ServerResponse;
import com.xc.service.IUserCashDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/agent/cash/"})
public class AgentCashDetailController
{
  private static final Logger log = LoggerFactory.getLogger(AgentCashDetailController.class);
  @Autowired
  IUserCashDetailService iUserCashDetailService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse list(HttpServletRequest request, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize, @RequestParam(value="userId", required=false) Integer userId, @RequestParam(value="userName", required=false) String userName, @RequestParam(value="agentId", required=false) Integer agentId, @RequestParam(value="positionId", required=false) Integer positionId)
  {
    return this.iUserCashDetailService.listByAgent(userId, userName, agentId, positionId, request, pageNum, pageSize);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.agent.AgentCashDetailController

 * JD-Core Version:    0.7.0.1

 */