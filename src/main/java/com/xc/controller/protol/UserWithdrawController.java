package com.xc.controller.protol;

import com.xc.common.ServerResponse;
import com.xc.pojo.User;
import com.xc.service.IUserService;
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
@RequestMapping({"/user/withdraw/"})
public class UserWithdrawController
{
  private static final Logger log = LoggerFactory.getLogger(UserWithdrawController.class);
  @Autowired
  IUserWithdrawService iUserWithdrawService;
  @Autowired
  IUserService iUserService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse list(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="8") int pageSize, @RequestParam(value="withStatus", required=false) String withStatus, HttpServletRequest request)
  {
    return this.iUserWithdrawService.findUserWithList(withStatus, request, pageNum, pageSize);
  }
  
  @RequestMapping({"outMoney.do"})
  @ResponseBody
  public ServerResponse outMoney(String amt, HttpServletRequest request)
  {
    ServerResponse serverResponse = null;
    User user = this.iUserService.getCurrentRefreshUser(request);
    try
    {
      serverResponse = this.iUserWithdrawService.outMoney(amt, user.getWithPwd(), request);
    }
    catch (Exception e)
    {
      log.error("出金异常 e = {}", e);
      serverResponse = ServerResponse.createByErrorMsg("出金异常，请稍后再试");
    }
    return serverResponse;
  }
  
  @RequestMapping({"cancel.do"})
  @ResponseBody
  public ServerResponse userCancel(Integer withId)
  {
    return this.iUserWithdrawService.userCancel(withId);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.protol.UserWithdrawController

 * JD-Core Version:    0.7.0.1

 */