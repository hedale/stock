package com.xc.controller.backend;

import com.xc.common.ServerResponse;
import com.xc.pojo.SiteIndexSetting;
import com.xc.service.ISiteIndexSettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/admin/site/index/"})
public class AdminSiteIndexSettingController
{
  private static final Logger log = LoggerFactory.getLogger(AdminSiteIndexSettingController.class);
  @Autowired
  ISiteIndexSettingService iSiteIndexSettingService;
  
  @RequestMapping({"update.do"})
  @ResponseBody
  public ServerResponse update(SiteIndexSetting siteIndexSetting)
  {
    return this.iSiteIndexSettingService.update(siteIndexSetting);
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.controller.backend.AdminSiteIndexSettingController
 * JD-Core Version:    0.7.0.1
 */