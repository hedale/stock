package com.xc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.dao.SiteMessageMapper;
import com.xc.pojo.SiteMessage;
import com.xc.pojo.User;
import com.xc.service.ISiteMessageService;
import com.xc.service.IUserService;
import com.xc.vo.agent.AgentAgencyFeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("ISiteMessageService")
public class SiteMessageServiceImpl
  implements ISiteMessageService
{
  @Resource
  private SiteMessageMapper siteMessageMapper;
  @Autowired
  IUserService iUserService;
  
  public int insert(SiteMessage siteMessage)
  {
    int ret = 0;
    if (siteMessage == null) {
      return 0;
    }
    ret = this.siteMessageMapper.insert(siteMessage);
    return ret;
  }
  
  public int update(SiteMessage siteMessage)
  {
    int ret = this.siteMessageMapper.update(siteMessage);
    return ret > 0 ? ret : 0;
  }
  
  public int delete(int id)
  {
    int ret = this.siteMessageMapper.delete(id);
    return ret > 0 ? ret : 0;
  }
  
  public ServerResponse<PageInfo> getSiteMessageByUserIdList(int pageNum, int pageSize, int userId, HttpServletRequest request)
  {
    Page<AgentAgencyFeeVO> page = PageHelper.startPage(pageNum, pageSize);
    int uid = 0;
    if (userId != 999)
    {
      User user = this.iUserService.getCurrentRefreshUser(request);
      uid = user.getId().intValue();
    }
    User user = this.iUserService.getCurrentRefreshUser(request);
    List<SiteMessage> siteMessageList = this.siteMessageMapper.getSiteMessageByUserIdList(Integer.valueOf(uid));
    PageInfo pageInfo = new PageInfo(page);
    pageInfo.setList(siteMessageList);
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  public int getIsDayCount(Integer userId, String typeName)
  {
    int ret = this.siteMessageMapper.getIsDayCount(userId, typeName);
    return ret > 0 ? ret : 0;
  }
  
  public int updateMessageStatus(HttpServletRequest request)
  {
    User user = this.iUserService.getCurrentRefreshUser(request);
    int ret = this.siteMessageMapper.updateMessageStatus(user.getId());
    return ret > 0 ? ret : 0;
  }
  
  public int getUnreadCount(HttpServletRequest request)
  {
    User user = this.iUserService.getCurrentRefreshUser(request);
    int ret = this.siteMessageMapper.getUnreadCount(user.getId());
    return ret > 0 ? ret : 0;
  }
  
  public ServerResponse del(Integer id, HttpServletRequest request)
  {
    if (id == null) {
      return ServerResponse.createByErrorMsg("id不能为空");
    }
    int updateCount = this.siteMessageMapper.delete(id.intValue());
    if (updateCount > 0) {
      return ServerResponse.createBySuccessMsg("删除成功");
    }
    return ServerResponse.createByErrorMsg("删除失败");
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.SiteMessageServiceImpl

 * JD-Core Version:    0.7.0.1

 */