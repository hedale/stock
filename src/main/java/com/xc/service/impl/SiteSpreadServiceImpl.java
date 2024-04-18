package com.xc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.dao.SiteSpreadMapper;
import com.xc.pojo.SiteSpread;
import com.xc.service.ISiteSpreadService;
import com.xc.vo.agent.AgentAgencyFeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("ISiteSpreadService")
public class SiteSpreadServiceImpl
  implements ISiteSpreadService
{
  @Autowired
  private SiteSpreadMapper siteSpreadMapper;
  
  public int insert(SiteSpread siteSpread)
  {
    int ret = 0;
    if (siteSpread == null) {
      return 0;
    }
    ret = this.siteSpreadMapper.insert(siteSpread);
    return ret;
  }
  
  public int delete(int id)
  {
    int ret = 0;
    if (id == 0) {
      return 0;
    }
    ret = this.siteSpreadMapper.delete(id);
    return ret;
  }
  
  public int update(SiteSpread siteSpread)
  {
    int ret = 0;
    if (siteSpread == null) {
      return 0;
    }
    ret = this.siteSpreadMapper.update(siteSpread);
    return ret;
  }
  
  public SiteSpread load(int id)
  {
    return this.siteSpreadMapper.load(id);
  }
  
  public ServerResponse<PageInfo> pageList(int pageNum, int pageSize, String typeName)
  {
    Page<AgentAgencyFeeVO> page = PageHelper.startPage(pageNum, pageSize);
    List<SiteSpread> list = this.siteSpreadMapper.pageList(pageNum, pageSize, typeName);
    PageInfo pageInfo = new PageInfo(page);
    pageInfo.setList(list);
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  public SiteSpread findSpreadRateOne(BigDecimal applies, BigDecimal turnover, String code, BigDecimal unitprice)
  {
    return this.siteSpreadMapper.findSpreadRateOne(applies, turnover, code, unitprice);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.SiteSpreadServiceImpl

 * JD-Core Version:    0.7.0.1

 */