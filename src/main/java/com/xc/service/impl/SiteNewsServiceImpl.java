package com.xc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.dao.SiteNewsMapper;
import com.xc.pojo.SiteNews;
import com.xc.service.ISiteNewsService;
import com.xc.utils.DateTimeUtil;
import com.xc.utils.HttpRequest;
import com.xc.utils.PropertiesUtil;
import com.xc.utils.StringUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("ISiteNewsService")
public class SiteNewsServiceImpl
  implements ISiteNewsService
{
  private static final Logger log = LoggerFactory.getLogger(SiteNewsServiceImpl.class);
  @Resource
  private SiteNewsMapper siteNewsMapper;
  
  public int insert(SiteNews model)
  {
    int ret = 0;
    if (model == null) {
      return 0;
    }
    ret = this.siteNewsMapper.insert(model);
    return ret;
  }
  
  public int update(SiteNews model)
  {
    int ret = this.siteNewsMapper.update(model);
    return ret > 0 ? ret : 0;
  }
  
  public ServerResponse save(SiteNews model)
  {
    int ret = 0;
    if ((model != null) && (model.getId().intValue() > 0)) {
      ret = this.siteNewsMapper.update(model);
    } else {
      ret = this.siteNewsMapper.insert(model);
    }
    if (ret > 0) {
      return ServerResponse.createBySuccessMsg("操作成功");
    }
    return ServerResponse.createByErrorMsg("操作失败");
  }
  
  public ServerResponse<PageInfo> getList(int pageNum, int pageSize, Integer type, String sort, String keyword, HttpServletRequest request)
  {
    PageHelper.startPage(pageNum, pageSize);
    List<SiteNews> listData = this.siteNewsMapper.pageList(pageNum, pageSize, type, sort, keyword);
    PageInfo pageInfo = new PageInfo(listData);
    pageInfo.setList(listData);
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  public ServerResponse getDetail(int id)
  {
    return ServerResponse.createBySuccess(this.siteNewsMapper.load(id));
  }
  
  public ServerResponse updateViews(Integer id)
  {
    return ServerResponse.createBySuccess(Integer.valueOf(this.siteNewsMapper.updateViews(id)));
  }
  
  public ServerResponse getTopNewsList(int pageSize)
  {
    List<SiteNews> listData = this.siteNewsMapper.getTopNewsList(pageSize);
    PageInfo pageInfo = new PageInfo();
    pageInfo.setList(listData);
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  public int grabNews()
  {
    int ret = 0;
    
    ret = addNews(Integer.valueOf(1), PropertiesUtil.getProperty("news.main.url") + "/pc_news/FastNews/GetImportantNewsList");
    log.info("财经要闻-抓取条数：" + ret);
    
    ret = addNews(Integer.valueOf(2), PropertiesUtil.getProperty("news.main.url") + "/pc_news/FastNews/GetInfoList?code=125&pageNumber=1&pagesize=20&condition=&r=");
    log.info("经济数据-抓取条数：" + ret);
    
    ret = addNews(Integer.valueOf(3), PropertiesUtil.getProperty("news.main.url") + "/pc_news/FastNews/GetInfoList?code=105&pageNumber=1&pagesize=20&condition=&r=");
    log.info("全球股市-抓取条数：" + ret);
    
    ret = addNews(Integer.valueOf(4), PropertiesUtil.getProperty("news.main.url") + "/pc_news/FastNews/GetInfoList?code=100&pageNumber=1&pagesize=20&condition=&r=");
    log.info("7*24全球-抓取条数：" + ret);
    
    ret = addNews(Integer.valueOf(5), PropertiesUtil.getProperty("news.main.url") + "/pc_news/FastNews/GetInfoList?code=106&pageNumber=1&pagesize=20&condition=&r=");
    log.info("商品资讯-抓取条数：" + ret);
    
    ret = addNews(Integer.valueOf(6), PropertiesUtil.getProperty("news.main.url") + "/pc_news/FastNews/GetInfoList?code=103&pageNumber=1&pagesize=20&condition=&r=");
    log.info("上市公司-抓取条数：" + ret);
    
    ret = addNews(Integer.valueOf(7), PropertiesUtil.getProperty("news.main.url") + "/pc_news/FastNews/GetInfoList?code=118&pageNumber=1&pagesize=20&condition=&r=");
    log.info("全球央行-抓取条数：" + ret);
    
    return ret;
  }
  
  private int addNews(Integer type, String url)
  {
    int k = 0;
    try
    {
      String newlist = HttpRequest.doGrabGet(url);
      JSONObject json = JSONObject.fromObject(newlist);
      if ((json != null) && (json.getJSONArray("items") != null) && (json.getJSONArray("items").size() > 0)) {
        for (int i = 0; i < json.getJSONArray("items").size(); i++)
        {
          JSONObject model = JSONObject.fromObject(json.getJSONArray("items").getString(i));
          String newsId = model.getString("code");
          String imgUrl = null;
          if (model.has("imgUrl")) {
            imgUrl = model.getString("imgUrl");
          }
          if (this.siteNewsMapper.getNewsBySourceIdCount(newsId) == 0)
          {
            String newdata = HttpRequest.doGrabGet(PropertiesUtil.getProperty("news.main.url") + "/PC_News/Detail/GetDetailContent?id=" + newsId + "&type=1");
            newdata = newdata.substring(1, newdata.length() - 1).replace("\\\\\\\"", "\"");
            newdata = newdata.replace("\\\"", "\"");
            newdata = StringUtils.UnicodeToCN(newdata);
            newdata = StringUtils.delHTMLTag(newdata);
            
            JSONObject jsonnew = JSONObject.fromObject(newdata);
            if ((jsonnew != null) && (jsonnew.get("data") != null))
            {
              JSONObject news = JSONObject.fromObject(jsonnew.get("data"));
              SiteNews siteNews = new SiteNews();
              siteNews.setSourceId(newsId);
              siteNews.setSourceName(news.getString("source"));
              siteNews.setTitle(news.getString("title"));
              String showTime = news.getString("showTime");
              siteNews.setShowTime(DateTimeUtil.strToDate(showTime));
              siteNews.setImgurl(imgUrl);
              siteNews.setDescription(news.getString("description"));
              siteNews.setContent(news.getString("content"));
              siteNews.setStatus(Integer.valueOf(1));
              siteNews.setType(type);
              this.siteNewsMapper.insert(siteNews);
              k++;
            }
          }
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return k;
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.SiteNewsServiceImpl

 * JD-Core Version:    0.7.0.1

 */