package com.xc.controller.backend;

import com.xc.common.ServerResponse;
import com.xc.pojo.FundsLever;
import com.xc.pojo.FundsSetting;
import com.xc.service.IFundsLeverService;
import com.xc.service.IFundsSettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/admin/funds/"})
public class AdminFundsSettingController
{
  private static final Logger log = LoggerFactory.getLogger(AdminAgentController.class);
  @Autowired
  IFundsSettingService iFundsSettingService;
  @Autowired
  IFundsLeverService iFundsLeverService;
  
  @RequestMapping({"saveFundsSetting.do"})
  @ResponseBody
  public ServerResponse save(FundsSetting fundsSetting, HttpServletRequest request)
  {
    return this.iFundsSettingService.save(fundsSetting, request);
  }
  
  @RequestMapping({"getFundsSetting.do"})
  @ResponseBody
  public ServerResponse getFundsSetting()
  {
    return ServerResponse.createBySuccess(this.iFundsSettingService.getFundsSetting());
  }
  
  @RequestMapping({"getFundsLeverList.do"})
  @ResponseBody
  public ServerResponse getFundsLeverList(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="12") int pageSize, HttpServletRequest request)
  {
    return ServerResponse.createBySuccess(this.iFundsLeverService.getFundsLeverList(pageNum, pageSize, request));
  }
  
  @RequestMapping({"saveFundsLever.do"})
  @ResponseBody
  public ServerResponse saveFundsLever(FundsLever fundsLever)
  {
    return ServerResponse.createBySuccess(this.iFundsLeverService.saveFundsLever(fundsLever));
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.backend.AdminFundsSettingController

 * JD-Core Version:    0.7.0.1

 */