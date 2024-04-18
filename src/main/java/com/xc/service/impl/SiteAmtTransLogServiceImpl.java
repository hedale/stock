package com.xc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.dao.SiteAmtTransLogMapper;
import com.xc.pojo.SiteAmtTransLog;
import com.xc.service.ISiteAmtTransLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iSiteAmtTransLogService")
public class SiteAmtTransLogServiceImpl
  implements ISiteAmtTransLogService
{
  private static final Logger log = LoggerFactory.getLogger(SiteAmtTransLogServiceImpl.class);
  @Autowired
  SiteAmtTransLogMapper siteAmtTransLogMapper;
  
  public ServerResponse<PageInfo> transList(Integer userId, String realName, int pageNum, int pageSize)
  {
    PageHelper.startPage(pageNum, pageSize);
    
    List<SiteAmtTransLog> siteAmtTransLogs = this.siteAmtTransLogMapper.transList(userId, realName);
    
    PageInfo pageInfo = new PageInfo(siteAmtTransLogs);
    
    return ServerResponse.createBySuccess(pageInfo);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.SiteAmtTransLogServiceImpl

 * JD-Core Version:    0.7.0.1

 */