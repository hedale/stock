package com.xc.controller.protol;

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
@RequestMapping({"/user/recharge/"})
public class UserRechargeController
{
  private static final Logger log = LoggerFactory.getLogger(UserRechargeController.class);
  @Autowired
  IUserRechargeService iUserRechargeService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse<PageInfo> list(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize, @RequestParam(value="payChannel", required=false) String payChannel, @RequestParam(value="orderStatus", required=false) String orderStatus, HttpServletRequest request)
  {
    return this.iUserRechargeService.findUserChargeList(payChannel, orderStatus, request, pageNum, pageSize);
  }
  
  @RequestMapping({"inMoney.do"})
  @ResponseBody
  public ServerResponse inMoney(String amt, String payType, HttpServletRequest request)
  {
    return this.iUserRechargeService.inMoney(amt, payType, request);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.protol.UserRechargeController

 * JD-Core Version:    0.7.0.1

 */