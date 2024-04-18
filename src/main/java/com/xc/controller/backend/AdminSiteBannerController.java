package com.xc.controller.backend;

import com.xc.common.ServerResponse;
import com.xc.pojo.SiteBanner;
import com.xc.service.ISiteBannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/admin/banners/"})
public class AdminSiteBannerController
{
  private static final Logger log = LoggerFactory.getLogger(AdminSiteBannerController.class);
  @Autowired
  ISiteBannerService iSiteBannerService;
  
  @RequestMapping({"add.do"})
  @ResponseBody
  public ServerResponse add(SiteBanner siteBanner)
  {
    return this.iSiteBannerService.add(siteBanner);
  }
  
  @RequestMapping({"update.do"})
  @ResponseBody
  public ServerResponse update(SiteBanner siteBanner)
  {
    return this.iSiteBannerService.update(siteBanner);
  }
  
  @RequestMapping({"delete.do"})
  @ResponseBody
  public ServerResponse delete(Integer id)
  {
    return this.iSiteBannerService.delete(id);
  }
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse list(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize)
  {
    return this.iSiteBannerService.listByAdmin(pageNum, pageSize);
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.controller.backend.AdminSiteBannerController
 * JD-Core Version:    0.7.0.1
 */