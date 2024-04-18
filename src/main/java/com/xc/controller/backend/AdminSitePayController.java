package com.xc.controller.backend;

import com.xc.common.ServerResponse;
import com.xc.pojo.SitePay;
import com.xc.service.ISitePayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/admin/pay/"})
public class AdminSitePayController
{
  private static final Logger log = LoggerFactory.getLogger(AdminSitePayController.class);
  @Autowired
  ISitePayService iSitePayService;
  
  @RequestMapping({"add.do"})
  @ResponseBody
  public ServerResponse add(SitePay sitePay)
  {
    return this.iSitePayService.add(sitePay);
  }
  
  @RequestMapping({"update.do"})
  @ResponseBody
  public ServerResponse update(SitePay sitePay)
  {
    return this.iSitePayService.update(sitePay);
  }
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse list(@RequestParam("channelType") String channelType, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize)
  {
    return this.iSitePayService.listByAdmin(channelType, pageNum, pageSize);
  }
  
  @RequestMapping({"del.do"})
  @ResponseBody
  public ServerResponse del(@RequestParam("cId") Integer cId)
  {
    return this.iSitePayService.del(cId);
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.controller.backend.AdminSitePayController
 * JD-Core Version:    0.7.0.1
 */