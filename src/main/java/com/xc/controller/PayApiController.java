package com.xc.controller;

import com.xc.common.ServerResponse;
import com.xc.dao.UserRechargeMapper;
import com.xc.pojo.UserRecharge;
import com.xc.service.IPayService;
import com.xc.service.IUserRechargeService;
import com.xc.service.IUserService;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping({"/api/pay/"})
public class PayApiController
{
  private static final Logger log = LoggerFactory.getLogger(PayApiController.class);
  @Autowired
  IPayService iPayService;
  @Autowired
  IUserService iUserService;
  @Autowired
  IUserRechargeService iUserRechargeService;
  @Autowired
  UserRechargeMapper userRechargeMapper;
  
  @RequestMapping({"juhe1Notify.do"})
  @ResponseBody
  public void juhe1Notify(HttpServletRequest request, HttpServletResponse response)
    throws IOException
  {
    ServerResponse serverResponse = this.iPayService.juhe1Notify(request);
    if (serverResponse.isSuccess())
    {
      response.getWriter().write("ok");
      log.info("第一个支付渠道的通知 返回 ok 成功");
    }
    else
    {
      log.error("juhe1Notify error Msg = {}", serverResponse.getMsg());
    }
  }
  
  @RequestMapping({"juhenewpayNotify.do"})
  @ResponseBody
  public JSONObject juhenewpayNotify(HttpServletRequest request, HttpServletResponse response)
    throws IOException
  {
    System.out.println("============开始回调===============");
    LinkedMap map = new LinkedMap();
    String orderno = request.getParameter("orderno");
    String amount = request.getParameter("payamount");
    String[] arr = orderno.split("_");
    map.put("payamount", request.getParameter("payamount"));
    map.put("orderno", orderno);
    map.put("status", request.getParameter("status"));
    log.info("回调创建订单前map===" + map.toString());
    
    JSONObject jsonObj = new JSONObject();
    Map<String, Object> json = new HashMap();
    if ("1".equals(request.getParameter("status")))
    {
      if (((amount != null ? 1 : 0) & (!StringUtils.isEmpty(amount) ? 1 : 0)) != 0)
      {
        System.out.println("============更新用户金额===============");
        Double aDouble = Double.valueOf(amount);
        Integer integer = Integer.valueOf(aDouble.intValue());
        
        UserRecharge userRecharge = this.userRechargeMapper.findUserRechargeByOrderSn(orderno);
        if (userRecharge == null)
        {
          System.out.println("============充值完成===============");
          this.iUserRechargeService.createOrder(Integer.valueOf(arr[0]), Integer.valueOf(1), Integer.valueOf(aDouble.intValue()), orderno);
          jsonObj.put("reason", "success");
        }
        else
        {
          System.out.println("============充值失败，已回调成功无需重复回调===============");
          jsonObj.put("reason", "error");
        }
      }
      else
      {
        jsonObj.put("reason", "error");
      }
      System.out.println("============回调成功并结束===============");
      
      return jsonObj;
    }
    System.out.println("============回调失败并结束===============");
    jsonObj.put("reason", "error");
    return jsonObj;
  }
  
  @RequestMapping({"juheh5payNotify.do"})
  @ResponseBody
  public void juheh5payNotify(HttpServletRequest request, HttpServletResponse response)
    throws IOException
  {
    System.out.println("============开始回调===============");
    LinkedMap map = new LinkedMap();
    String orderno = request.getParameter("name");
    String amount = request.getParameter("money");
    String[] arr = orderno.split("_");
    map.put("money", request.getParameter("money"));
    map.put("name", orderno);
    log.info("回调创建订单前map===" + map.toString());
    
    JSONObject jsonObj = new JSONObject();
    Map<String, Object> json = new HashMap();
    if (((amount != null ? 1 : 0) & (!StringUtils.isEmpty(amount) ? 1 : 0)) != 0)
    {
      System.out.println("============更新用户金额===============");
      Double aDouble = Double.valueOf(amount);
      Integer integer = Integer.valueOf(aDouble.intValue());
      
      UserRecharge userRecharge = this.userRechargeMapper.findUserRechargeByOrderSn(orderno);
      if (userRecharge == null)
      {
        System.out.println("============充值完成===============");
        this.iUserRechargeService.createOrder(Integer.valueOf(arr[0]), Integer.valueOf(1), Integer.valueOf(aDouble.intValue()), orderno);
      }
      else
      {
        System.out.println("============充值失败，已回调成功无需重复回调===============");
      }
    }
    System.out.println("============回调成功并结束===============");
    
    response.getWriter().write("success");
  }
  
  @RequestMapping({"flyNotify.do"})
  @ResponseBody
  public void flyNotify(HttpServletRequest request, HttpServletResponse response)
    throws IOException
  {
    ServerResponse serverResponse = this.iPayService.flyNotify(request);
    if (serverResponse.isSuccess())
    {
      response.getWriter().write("{\"reason\":\"success\"}");
      log.info("fly 支付渠道的通知 返回 success 成功");
    }
    else
    {
      log.error("fly notify error Msg = {}", serverResponse.getMsg());
    }
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.PayApiController

 * JD-Core Version:    0.7.0.1

 */