package com.xc.controller;

import com.xc.common.ServerResponse;
import com.xc.service.ISiteNewsService;
import com.xc.service.IUserPositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/api/news/"})
public class SiteNewsController
{
  private static final Logger log = LoggerFactory.getLogger(SiteNewsController.class);
  @Autowired
  ISiteNewsService iSiteNewsService;
  @Autowired
  IUserPositionService iUserPositionService;
  
  @RequestMapping({"getNewsList.do"})
  @ResponseBody
  public ServerResponse getNewsList(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="15") int pageSize, @RequestParam(value="type", defaultValue="0") Integer type, @RequestParam(value="sort", defaultValue="time1") String sort, @RequestParam(value="keyword", required=false) String keyword, HttpServletRequest request)
  {
    return this.iSiteNewsService.getList(pageNum, pageSize, type, sort, keyword, request);
  }
  
  @RequestMapping({"getDetail.do"})
  @ResponseBody
  public ServerResponse getDetail(int id)
  {
    return this.iSiteNewsService.getDetail(id);
  }
  
  @RequestMapping({"updateViews.do"})
  @ResponseBody
  public ServerResponse updateViews(Integer id)
  {
    return this.iSiteNewsService.updateViews(id);
  }
  
  @RequestMapping({"getTopNews.do"})
  @ResponseBody
  public ServerResponse getTopNewsList(@RequestParam(value="pageSize", defaultValue="15") int pageSize)
  {
    return this.iSiteNewsService.getTopNewsList(pageSize);
  }
  
  @RequestMapping({"getPositionTop.do"})
  @ResponseBody
  public ServerResponse findPositionTopList(@RequestParam(value="pageSize", defaultValue="15") int pageSize)
  {
    return this.iUserPositionService.findPositionTopList(Integer.valueOf(pageSize));
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.SiteNewsController

 * JD-Core Version:    0.7.0.1

 */