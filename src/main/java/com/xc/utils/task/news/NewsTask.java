package com.xc.utils.task.news;

import com.xc.service.ISiteArticleService;
import com.xc.service.ISiteNewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NewsTask
{
  private static final Logger log = LoggerFactory.getLogger(NewsTask.class);
  @Autowired
  ISiteNewsService iSiteNewsService;
  @Autowired
  ISiteArticleService iSiteArticleService;
  
  @Scheduled(cron="0 0/30 9-20 * * ?")
  public void NewsInfoTask()
  {
    this.iSiteNewsService.grabNews();
  }
  
  @Scheduled(cron="0 0/30 9-20 * * ?")
  public void ArtInfoTask()
  {
    this.iSiteArticleService.grabArticle();
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.utils.task.news.NewsTask
 * JD-Core Version:    0.7.0.1
 */