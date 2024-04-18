package com.xc.controller.backend;

import com.xc.common.ServerResponse;
import com.xc.pojo.SiteFuturesSetting;
import com.xc.service.ISiteFuturesSettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/admin/site/futures/"})
public class AdminSiteFuturesSettingController
{
  private static final Logger log = LoggerFactory.getLogger(AdminSiteFuturesSettingController.class);
  @Autowired
  ISiteFuturesSettingService iSiteFuturesSettingService;
  
  @RequestMapping({"update.do"})
  @ResponseBody
  public ServerResponse update(SiteFuturesSetting siteFuturesSetting)
  {
    return this.iSiteFuturesSettingService.update(siteFuturesSetting);
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.controller.backend.AdminSiteFuturesSettingController
 * JD-Core Version:    0.7.0.1
 */