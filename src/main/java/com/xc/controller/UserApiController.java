package com.xc.controller;

import com.xc.common.ServerResponse;
import com.xc.pojo.SiteSpread;
import com.xc.service.ISiteSpreadService;
import com.xc.service.IUserService;
import com.xc.utils.PropertiesUtil;
import com.xc.utils.redis.CookieUtils;
import com.xc.utils.redis.JsonUtil;
import com.xc.utils.redis.RedisConst;
import com.xc.utils.redis.RedisShardedPoolUtils;
import com.xc.vo.user.UserLoginResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
@RequestMapping({"/api/user/"})
public class UserApiController
{
  private static final Logger log = LoggerFactory.getLogger(UserApiController.class);
  @Autowired
  IUserService iUserService;
  @Autowired
  ISiteSpreadService iSiteSpreadService;
  
  @RequestMapping(value={"reg.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public ServerResponse reg(@RequestParam("agentCode") String agentCode, @RequestParam("phone") String phone, @RequestParam(value="yzmCode", defaultValue="") String yzmCode, @RequestParam("userPwd") String userPwd, HttpServletRequest httpServletRequest)
  {
    return this.iUserService.reg(yzmCode, agentCode, phone, userPwd, httpServletRequest);
  }
  
  @RequestMapping(value={"login.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public ServerResponse login(@RequestParam("phone") String phone, @RequestParam("userPwd") String userPwd, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response)
  {
    String pc_cookie_name = PropertiesUtil.getProperty("user.cookie.name");
    String token = RedisConst.getUserRedisKey(httpSession.getId());
    ServerResponse serverResponse = this.iUserService.login(phone, userPwd, request);
    if (serverResponse.isSuccess())
    {
      CookieUtils.writeLoginToken(response, token, pc_cookie_name);
      String redisSetExResult = RedisShardedPoolUtils.setEx(token, JsonUtil.obj2String(serverResponse.getData()), 5400);
      log.info("redis setex user result : {}", redisSetExResult);
      UserLoginResultVO resultVO = new UserLoginResultVO();
      resultVO.setKey(pc_cookie_name);
      resultVO.setToken(token);
      return ServerResponse.createBySuccess("登陆成功", resultVO);
    }
    return serverResponse;
  }
  
  @RequestMapping({"logout.do"})
  @ResponseBody
  public ServerResponse logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
  {
    String cookie_name = PropertiesUtil.getProperty("user.cookie.name");
    String logintoken = CookieUtils.readLoginToken(httpServletRequest, cookie_name);
    log.info("用户 token = {} ,退出登陆", logintoken);
    RedisShardedPoolUtils.del(logintoken);
    CookieUtils.delLoginToken(httpServletRequest, httpServletResponse, cookie_name);
    return ServerResponse.createBySuccess();
  }
  
  @RequestMapping({"checkPhone.do"})
  @ResponseBody
  public ServerResponse checkPhone(String phoneNum)
  {
    return this.iUserService.checkPhone(phoneNum);
  }
  
  @RequestMapping({"updatePwd.do"})
  @ResponseBody
  public ServerResponse updatePwd(String phoneNum, String code, String newPwd)
  {
    return this.iUserService.updatePwd(phoneNum, code, newPwd);
  }
  
  @RequestMapping({"findSpreadRateOne.do"})
  @ResponseBody
  public ServerResponse findSpreadRateOne(BigDecimal applies, BigDecimal turnover, String code, BigDecimal unitprice)
  {
    SiteSpread siteSpread = this.iSiteSpreadService.findSpreadRateOne(applies, turnover, code, unitprice);
    return ServerResponse.createBySuccess("获取成功", siteSpread);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.UserApiController

 * JD-Core Version:    0.7.0.1

 */