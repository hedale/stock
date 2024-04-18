package com.xc.controller.backend;

import com.github.pagehelper.PageInfo;
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
@RequestMapping({"/admin/withdraw/"})
public class AdminWithDrawController
{
  private static final Logger log = LoggerFactory.getLogger(AdminWithDrawController.class);
  @Autowired
  IUserWithdrawService iUserWithdrawService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse<PageInfo> list(@RequestParam(value="agentId", required=false) Integer agentId, @RequestParam(value="userId", required=false) Integer userId, @RequestParam(value="realName", required=false) String realName, @RequestParam(value="state", required=false) Integer state, @RequestParam(value="beginTime", required=false) String beginTime, @RequestParam(value="endTime", required=false) String endTime, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize, HttpServletRequest request)
  {
    return this.iUserWithdrawService.listByAdmin(agentId, userId, realName, state, beginTime, endTime, request, pageNum, pageSize);
  }
  
  @RequestMapping({"updateState.do"})
  @ResponseBody
  public ServerResponse updateState(@RequestParam(value="withId", required=false) Integer withId, @RequestParam(value="state", required=false) Integer state, @RequestParam(value="authMsg", required=false) String authMsg)
  {
    ServerResponse serverResponse = null;
    try
    {
      serverResponse = this.iUserWithdrawService.updateState(withId, state, authMsg);
    }
    catch (Exception e)
    {
      log.error("admin修改充值订单状态出错 ，异常 = {}", e);
    }
    return serverResponse;
  }
  
  @RequestMapping({"deleteWithdraw.do"})
  @ResponseBody
  public ServerResponse deleteWithdraw(Integer withdrawId)
  {
    return this.iUserWithdrawService.deleteWithdraw(withdrawId);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.backend.AdminWithDrawController

 * JD-Core Version:    0.7.0.1

 */