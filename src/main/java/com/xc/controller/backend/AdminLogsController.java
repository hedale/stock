package com.xc.controller.backend;

import com.xc.common.ServerResponse;
import com.xc.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/admin/log/"})
public class AdminLogsController
{
  private static final Logger log = LoggerFactory.getLogger(AdminLogsController.class);
  @Autowired
  ISiteLoginLogService iSiteLoginLogService;
  @Autowired
  ISiteTaskLogService iSiteTaskLogService;
  @Autowired
  ISiteSmsLogService iSiteSmsLogService;
  @Autowired
  ISiteAmtTransLogService iSiteAmtTransLogService;
  @Autowired
  ISiteMessageService iSiteMessageService;
  
  @RequestMapping({"taskList.do"})
  @ResponseBody
  public ServerResponse taskList(@RequestParam(value="taskType", required=false) String taskType, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize)
  {
    return this.iSiteTaskLogService.taskList(taskType, pageNum, pageSize);
  }
  
  @RequestMapping({"loginList.do"})
  @ResponseBody
  public ServerResponse loginList(@RequestParam(value="userId", required=false) Integer userId, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize)
  {
    return this.iSiteLoginLogService.loginList(userId, pageNum, pageSize);
  }
  
  @RequestMapping({"smsList.do"})
  @ResponseBody
  public ServerResponse smsList(@RequestParam(value="phoneNum", required=false) String phoneNum, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize)
  {
    return this.iSiteSmsLogService.smsList(phoneNum, pageNum, pageSize);
  }
  
  @RequestMapping({"transList.do"})
  @ResponseBody
  public ServerResponse transList(@RequestParam(value="userId", required=false) Integer userId, @RequestParam(value="realName", required=false) String realName, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize)
  {
    return this.iSiteAmtTransLogService.transList(userId, realName, pageNum, pageSize);
  }
  
  @RequestMapping({"messageList.do"})
  @ResponseBody
  public ServerResponse messageList(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize, HttpServletRequest request)
  {
    return this.iSiteMessageService.getSiteMessageByUserIdList(pageNum, pageSize, 999, request);
  }
  
  @RequestMapping({"delLogin.do"})
  @ResponseBody
  public ServerResponse del(Integer id, HttpServletRequest request)
  {
    return this.iSiteLoginLogService.del(id, request);
  }
  
  @RequestMapping({"delSms.do"})
  @ResponseBody
  public ServerResponse delSms(Integer id, HttpServletRequest request)
  {
    return this.iSiteSmsLogService.del(id, request);
  }
  
  @RequestMapping({"delTask.do"})
  @ResponseBody
  public ServerResponse delTask(Integer id, HttpServletRequest request)
  {
    return this.iSiteTaskLogService.del(id, request);
  }
  
  @RequestMapping({"delMessageList.do"})
  @ResponseBody
  public ServerResponse delMessageList(Integer id, HttpServletRequest request)
  {
    return this.iSiteMessageService.del(id, request);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.backend.AdminLogsController

 * JD-Core Version:    0.7.0.1

 */