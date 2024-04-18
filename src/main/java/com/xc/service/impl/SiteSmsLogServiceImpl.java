package com.xc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.dao.SiteSmsLogMapper;
import com.xc.pojo.SiteSmsLog;
import com.xc.service.ISiteSmsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("iSiteSmsLogService")
public class SiteSmsLogServiceImpl
  implements ISiteSmsLogService
{
  @Autowired
  SiteSmsLogMapper siteSmsLogMapper;
  
  public ServerResponse smsList(String phoneNum, int pageNum, int pageSize)
  {
    PageHelper.startPage(pageNum, pageSize);
    List smslist = this.siteSmsLogMapper.smsList(phoneNum);
    PageInfo pageInfo = new PageInfo(smslist);
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  public void addData(SiteSmsLog siteSmsLog)
  {
    this.siteSmsLogMapper.insert(siteSmsLog);
  }
  
  public ServerResponse del(Integer id, HttpServletRequest request)
  {
    if (id == null) {
      return ServerResponse.createByErrorMsg("id不能为空");
    }
    int updateCount = this.siteSmsLogMapper.deleteByPrimaryKey(id);
    if (updateCount > 0) {
      return ServerResponse.createBySuccessMsg("删除成功");
    }
    return ServerResponse.createByErrorMsg("删除失败");
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.SiteSmsLogServiceImpl

 * JD-Core Version:    0.7.0.1

 */