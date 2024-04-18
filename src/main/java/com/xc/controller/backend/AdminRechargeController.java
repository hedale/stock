package com.xc.controller.backend;

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
@RequestMapping({"/admin/recharge/"})
public class AdminRechargeController
{
  private static final Logger log = LoggerFactory.getLogger(AdminRechargeController.class);
  @Autowired
  IUserRechargeService iUserRechargeService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse<PageInfo> list(@RequestParam(value="agentId", required=false) Integer agentId, @RequestParam(value="userId", required=false) Integer userId, @RequestParam(value="realName", required=false) String realName, @RequestParam(value="state", required=false) Integer state, @RequestParam(value="beginTime", required=false) String beginTime, @RequestParam(value="endTime", required=false) String endTime, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize, HttpServletRequest request)
  {
    return this.iUserRechargeService.listByAdmin(agentId, userId, realName, state, beginTime, endTime, request, pageNum, pageSize);
  }
  
  @RequestMapping({"updateState.do"})
  @ResponseBody
  public ServerResponse updateState(@RequestParam(value="chargeId", required=false) Integer chargeId, @RequestParam(value="state", required=false) Integer state)
  {
    ServerResponse serverResponse = null;
    try
    {
      serverResponse = this.iUserRechargeService.updateState(chargeId, state);
    }
    catch (Exception e)
    {
      log.error("admin修改充值订单状态出错 ，异常 = {}", e);
    }
    return serverResponse;
  }
  
  @RequestMapping({"createOrder.do"})
  @ResponseBody
  public ServerResponse createOrder(@RequestParam(value="userId", required=false) Integer userId, @RequestParam(value="state", required=false) Integer state, @RequestParam(value="amt", required=false) Integer amt, @RequestParam(value="payChannel", required=false) String payChannel)
  {
    return this.iUserRechargeService.createOrder(userId, state, amt, payChannel);
  }
  
  @RequestMapping({"del.do"})
  @ResponseBody
  public ServerResponse del(@RequestParam("cId") Integer cId)
  {
    return this.iUserRechargeService.del(cId);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.backend.AdminRechargeController

 * JD-Core Version:    0.7.0.1

 */