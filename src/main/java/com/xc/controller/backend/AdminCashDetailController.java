package com.xc.controller.backend;

import com.xc.common.ServerResponse;
import com.xc.service.IUserCashDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/admin/cash/"})
public class AdminCashDetailController
{
  private static final Logger log = LoggerFactory.getLogger(AdminCashDetailController.class);
  @Autowired
  IUserCashDetailService iUserCashDetailService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse list(@RequestParam(value="userId", required=false) Integer userId, @RequestParam(value="userName", required=false) String userName, @RequestParam(value="agentId", required=false) Integer agentId, @RequestParam(value="positionId", required=false) Integer positionId, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize)
  {
    return this.iUserCashDetailService.listByAdmin(userId, userName, agentId, positionId, pageNum, pageSize);
  }
  
  @RequestMapping({"delCash.do"})
  @ResponseBody
  public ServerResponse delCash(Integer cashId)
  {
    return this.iUserCashDetailService.delCash(cashId);
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.controller.backend.AdminCashDetailController
 * JD-Core Version:    0.7.0.1
 */