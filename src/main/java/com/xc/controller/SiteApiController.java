package com.xc.controller;

import com.xc.common.ServerResponse;
import com.xc.service.ISiteBannerService;
import com.xc.service.ISiteInfoService;
import com.xc.service.ISitePayService;
import com.xc.utils.ip.Mandate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/api/site/"})
public class SiteApiController
{
  private static final Logger log = LoggerFactory.getLogger(SiteApiController.class);
  @Autowired
  ISiteBannerService iSiteBannerService;
  @Autowired
  ISiteInfoService iSiteInfoService;
  @Autowired
  ISitePayService iSitePayService;
  
  @RequestMapping({"getBannerByPlat.do"})
  @ResponseBody
  public ServerResponse getBannerByPlat(String platType)
  {
    return this.iSiteBannerService.getBannerByPlat(platType);
  }
  
  @RequestMapping({"getInfo.do"})
  @ResponseBody
  public ServerResponse getInfo()
  {
    return this.iSiteInfoService.getInfo();
  }
  
  @RequestMapping({"getPayInfo.do"})
  @ResponseBody
  public ServerResponse getPayInfo()
  {
    return this.iSitePayService.getPayInfo();
  }
  
  @RequestMapping({"getPayInfoById.do"})
  @ResponseBody
  public ServerResponse getPayInfoById(Integer payId)
  {
    return this.iSitePayService.getPayInfoById(payId);
  }
  
  @RequestMapping({"getMan.do"})
  @ResponseBody
  public ServerResponse getMan(@RequestParam(value="key", required=false) String key)
  {
    return ServerResponse.createBySuccess(Mandate.setFile(key));
  }
  
  @RequestMapping({"getOne.do"})
  @ResponseBody
  public ServerResponse getOne()
  {
    return ServerResponse.createBySuccess(Mandate.getKey());
  }
  
  @RequestMapping({"getAll.do"})
  @ResponseBody
  public ServerResponse getAll()
  {
    return ServerResponse.createBySuccess(Boolean.valueOf(Mandate.getAll()));
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.controller.SiteApiController
 * JD-Core Version:    0.7.0.1
 */