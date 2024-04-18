package com.xc.controller.protol;

import com.xc.common.ServerResponse;
import com.xc.service.IStockOptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/user/option/"})
public class UserOptionController
{
  private static final Logger log = LoggerFactory.getLogger(UserOptionController.class);
  @Autowired
  IStockOptionService iStockOptionService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse list(HttpServletRequest request, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize, @RequestParam(value="keyWords", required=false) String keyWords)
  {
    return this.iStockOptionService.findMyStockOptions(keyWords, request, pageNum, pageSize);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.protol.UserOptionController

 * JD-Core Version:    0.7.0.1

 */