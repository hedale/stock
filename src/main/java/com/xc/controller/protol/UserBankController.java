package com.xc.controller.protol;

import com.xc.common.ServerResponse;
import com.xc.pojo.UserBank;
import com.xc.service.IUserBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/user/bank/"})
public class UserBankController
{
  private static final Logger log = LoggerFactory.getLogger(UserBankController.class);
  @Autowired
  IUserBankService iUserBankService;
  
  @RequestMapping({"add.do"})
  @ResponseBody
  public ServerResponse add(UserBank bank, HttpServletRequest request)
  {
    return this.iUserBankService.addBank(bank, request);
  }
  
  @RequestMapping({"update.do"})
  @ResponseBody
  public ServerResponse update(UserBank bank, HttpServletRequest request)
  {
    return this.iUserBankService.updateBank(bank, request);
  }
  
  @RequestMapping({"getBankInfo.do"})
  @ResponseBody
  public ServerResponse getBankInfo(HttpServletRequest request)
  {
    return this.iUserBankService.getBankInfo(request);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.protol.UserBankController

 * JD-Core Version:    0.7.0.1

 */