package com.xc.controller.backend;

import com.xc.common.ServerResponse;
import com.xc.pojo.User;
import com.xc.pojo.UserBank;
import com.xc.service.IUserBankService;
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
@RequestMapping({"/admin/user/"})
public class AdminUserController
{
  private static final Logger log = LoggerFactory.getLogger(AdminUserController.class);
  @Autowired
  IUserService iUserService;
  @Autowired
  IUserBankService iUserBankService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse list(@RequestParam(value="realName", required=false) String realName, @RequestParam(value="phone", required=false) String phone, @RequestParam(value="agentId", required=false) Integer agentId, @RequestParam(value="accountType", required=false) Integer accountType, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize, HttpServletRequest request)
  {
    return this.iUserService.listByAdmin(realName, phone, agentId, accountType, pageNum, pageSize, request);
  }
  
  @RequestMapping({"detail.do"})
  @ResponseBody
  public ServerResponse detail(Integer userId)
  {
    return this.iUserService.findByUserId(userId);
  }
  
  @RequestMapping({"updateLock.do"})
  @ResponseBody
  public ServerResponse updateLock(Integer userId)
  {
    return this.iUserService.updateLock(userId);
  }
  
  @RequestMapping({"updateAmt.do"})
  @ResponseBody
  public ServerResponse updateAmt(Integer userId, Integer amt, Integer direction)
  {
    return this.iUserService.updateAmt(userId, amt, direction);
  }
  
  @RequestMapping({"update.do"})
  @ResponseBody
  public ServerResponse update(User user)
  {
    return this.iUserService.update(user);
  }
  
  @RequestMapping({"updateBank.do"})
  @ResponseBody
  public ServerResponse updateBank(UserBank userBank)
  {
    return this.iUserBankService.updateBankByAdmin(userBank);
  }
  
  @RequestMapping({"addSimulatedAccount.do"})
  @ResponseBody
  public ServerResponse addSimulatedAccount(HttpServletRequest request, @RequestParam(value="agentId", required=false) Integer agentId, @RequestParam("phone") String phone, @RequestParam("amt") String amt, @RequestParam("accountType") Integer accountType, @RequestParam("pwd") String pwd)
  {
    return this.iUserService.addSimulatedAccount(agentId, phone, pwd, amt, accountType, request);
  }
  
  @RequestMapping({"authByAdmin.do"})
  @ResponseBody
  public ServerResponse authByAdmin(Integer userId, Integer state, String authMsg)
  {
    return this.iUserService.authByAdmin(userId, state, authMsg);
  }
  
  @RequestMapping({"getBank.do"})
  @ResponseBody
  public ServerResponse getBank(Integer userId)
  {
    return this.iUserBankService.getBank(userId);
  }
  
  @RequestMapping({"delete.do"})
  @ResponseBody
  public ServerResponse delete(Integer userId, HttpServletRequest request)
  {
    return this.iUserService.delete(userId, request);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.backend.AdminUserController

 * JD-Core Version:    0.7.0.1

 */