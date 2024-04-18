package com.xc.controller.backend;

import com.xc.common.ServerResponse;
import com.xc.service.IUserPositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/admin/position/"})
public class AdminPositionController
{
  private static final Logger log = LoggerFactory.getLogger(AdminPositionController.class);
  @Autowired
  IUserPositionService iUserPositionService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse list(@RequestParam(value="agentId", required=false) Integer agentId, @RequestParam(value="positionType", required=false) Integer positionType, @RequestParam(value="state", required=false) Integer state, @RequestParam(value="userId", required=false) Integer userId, @RequestParam(value="positionSn", required=false) String positionSn, @RequestParam(value="beginTime", required=false) String beginTime, @RequestParam(value="endTime", required=false) String endTime, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="12") int pageSize, HttpServletRequest request)
  {
    return this.iUserPositionService.listByAdmin(agentId, positionType, state, userId, positionSn, beginTime, endTime, pageNum, pageSize);
  }
  
  @RequestMapping({"sell.do"})
  @ResponseBody
  public ServerResponse sell(String positionSn)
    throws Exception
  {
    ServerResponse serverResponse = null;
    try
    {
      serverResponse = this.iUserPositionService.sell(positionSn, 0);
    }
    catch (Exception e)
    {
      log.error("强制平仓 异常信息 = {}", e);
    }
    return serverResponse;
  }
  
  @RequestMapping({"lock.do"})
  @ResponseBody
  public ServerResponse lock(@RequestParam("positionId") Integer positionId, @RequestParam("state") Integer state, @RequestParam(value="lockMsg", required=false) String lockMsg)
  {
    return this.iUserPositionService.lock(positionId, state, lockMsg);
  }
  
  @RequestMapping({"del.do"})
  @ResponseBody
  public ServerResponse del(@RequestParam("positionId") Integer positionId)
  {
    return this.iUserPositionService.del(positionId);
  }
  
  @RequestMapping({"create.do"})
  @ResponseBody
  public ServerResponse create(@RequestParam("userId") Integer userId, @RequestParam("stockCode") String stockCode, @RequestParam("buyPrice") String buyPrice, @RequestParam("buyTime") String buyTime, @RequestParam("buyNum") Integer buyNum, @RequestParam("buyType") Integer buyType, @RequestParam("lever") Integer lever)
  {
    return this.iUserPositionService.create(userId, stockCode, buyPrice, buyTime, buyNum, buyType, lever);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.backend.AdminPositionController

 * JD-Core Version:    0.7.0.1

 */