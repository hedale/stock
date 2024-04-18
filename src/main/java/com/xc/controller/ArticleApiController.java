package com.xc.controller;

import com.xc.common.ServerResponse;
import com.xc.service.ISiteArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/api/art/"})
public class ArticleApiController
{
  private static final Logger log = LoggerFactory.getLogger(ArticleApiController.class);
  @Autowired
  ISiteArticleService iSiteArticleService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse list(@RequestParam(value="artTitle", required=false) String artTitle, @RequestParam(value="artType", required=false) String artType, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="12") int pageSize)
  {
    return this.iSiteArticleService.list(artTitle, artType, pageNum, pageSize);
  }
  
  @RequestMapping({"detail.do"})
  @ResponseBody
  public ServerResponse detail(Integer artId)
  {
    return this.iSiteArticleService.detail(artId);
  }
  
  @RequestMapping({"getTopArt.do"})
  @ResponseBody
  public ServerResponse getTopArtList(@RequestParam(value="pageSize", defaultValue="15") int pageSize)
  {
    return this.iSiteArticleService.getTopArtList(pageSize);
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.controller.ArticleApiController
 * JD-Core Version:    0.7.0.1
 */