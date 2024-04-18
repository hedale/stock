package com.xc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.common.ServerResponse;
import com.xc.dao.UserMapper;
import com.xc.dao.UserStockSubscribeMapper;
import com.xc.pojo.SiteAdmin;
import com.xc.pojo.SiteMessage;
import com.xc.pojo.User;
import com.xc.pojo.UserStockSubscribe;
import com.xc.service.ISiteMessageService;
import com.xc.service.IUserStockSubscribeService;
import com.xc.utils.DateTimeUtil;
import com.xc.utils.PropertiesUtil;
import com.xc.utils.redis.CookieUtils;
import com.xc.utils.redis.JsonUtil;
import com.xc.utils.redis.RedisShardedPoolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("IUserStockSubscribeService")
public class UserStockSubscribeServiceImpl
  implements IUserStockSubscribeService
{
  @Resource
  private UserStockSubscribeMapper userStockSubscribeMapper;
  @Autowired
  UserMapper userMapper;
  @Autowired
  ISiteMessageService iSiteMessageService;
  
  public int insert(UserStockSubscribe model)
  {
    int ret = 0;
    if (model == null) {
      return 0;
    }
    ret = this.userStockSubscribeMapper.insert(model);
    return ret;
  }
  
  public int update(UserStockSubscribe model)
  {
    int ret = this.userStockSubscribeMapper.update(model);
    return ret > 0 ? ret : 0;
  }
  
  public ServerResponse save(UserStockSubscribe model, HttpServletRequest request)
  {
    int ret = 0;
    if ((model != null) && (model.getId().intValue() > 0))
    {
      model.setEndTime(DateTimeUtil.getCurrentDate());
      ret = this.userStockSubscribeMapper.update(model);
      UserStockSubscribe userStockSubscribe = this.userStockSubscribeMapper.load(model.getId().intValue());
      if ((model.getSubmitAmount() == null) || (model.getSubmitAmount().intValue() <= 0))
      {
        if ((ret > 0) && (model.getStatus().intValue() == 3))
        {
          SiteMessage siteMessage = new SiteMessage();
          siteMessage.setUserId(userStockSubscribe.getUserId());
          siteMessage.setUserName(userStockSubscribe.getRealName());
          siteMessage.setTypeName("新股申购");
          siteMessage.setStatus(Integer.valueOf(1));
          siteMessage.setContent("【新股申购中签】恭喜您，新股申购中签成功，申购金额：" + userStockSubscribe.getSubmitAmount() + "，请及时关注哦。");
          siteMessage.setAddTime(DateTimeUtil.getCurrentDate());
          this.iSiteMessageService.insert(siteMessage);
        }
        if ((ret > 0) && (model.getStatus().intValue() == 4))
        {
          SiteMessage siteMessage = new SiteMessage();
          siteMessage.setUserId(userStockSubscribe.getUserId());
          siteMessage.setUserName(userStockSubscribe.getRealName());
          siteMessage.setTypeName("新股申购");
          siteMessage.setStatus(Integer.valueOf(1));
          siteMessage.setContent("【新股申购未中签】很遗憾，您的新股申购本次未签，申购金额：" + userStockSubscribe.getSubmitAmount() + "。");
          siteMessage.setAddTime(DateTimeUtil.getCurrentDate());
          this.iSiteMessageService.insert(siteMessage);
        }
      }
    }
    else
    {
      if (model.getUserId() != null)
      {
        User user = this.userMapper.selectByPrimaryKey(model.getUserId());
        model.setRealName(user.getRealName());
        model.setPhone(user.getPhone());
      }
      String cookie_name = PropertiesUtil.getProperty("admin.cookie.name");
      String logintoken = CookieUtils.readLoginToken(request, cookie_name);
      String adminJson = RedisShardedPoolUtils.get(logintoken);
      SiteAdmin siteAdmin = (SiteAdmin)JsonUtil.string2Obj(adminJson, SiteAdmin.class);
      model.setAdminId(siteAdmin.getId());
      model.setAdminName(siteAdmin.getAdminName());
      model.setAddTime(DateTimeUtil.getCurrentDate());
      model.setStatus(Integer.valueOf(1));
      ret = this.userStockSubscribeMapper.insert(model);
    }
    if (ret > 0) {
      return ServerResponse.createBySuccessMsg("操作成功");
    }
    return ServerResponse.createByErrorMsg("操作失败");
  }
  
  public ServerResponse sendMsg(UserStockSubscribe model, HttpServletRequest request)
  {
    int ret = 0;
    if (model != null) {
      if (model.getUserId().intValue() == 0)
      {
        List<User> users = this.userMapper.listByAdmin(null, null, null, null);
        for (int k = 0; k < users.size(); k++)
        {
          User user = (User)users.get(k);
          SiteMessage siteMessage = new SiteMessage();
          siteMessage.setUserId(user.getId());
          siteMessage.setUserName(user.getRealName());
          siteMessage.setTypeName("站内消息");
          siteMessage.setStatus(Integer.valueOf(1));
          siteMessage.setContent("【站内消息】" + model.getRemarks());
          siteMessage.setAddTime(DateTimeUtil.getCurrentDate());
          ret = this.iSiteMessageService.insert(siteMessage);
        }
      }
      else
      {
        User user = this.userMapper.selectByPrimaryKey(model.getUserId());
        SiteMessage siteMessage = new SiteMessage();
        siteMessage.setUserId(user.getId());
        siteMessage.setUserName(user.getRealName());
        siteMessage.setTypeName("站内消息");
        siteMessage.setStatus(Integer.valueOf(1));
        siteMessage.setContent("【站内消息】" + model.getRemarks());
        siteMessage.setAddTime(DateTimeUtil.getCurrentDate());
        ret = this.iSiteMessageService.insert(siteMessage);
      }
    }
    if (ret > 0) {
      return ServerResponse.createBySuccessMsg("操作成功");
    }
    return ServerResponse.createByErrorMsg("操作失败");
  }
  
  public ServerResponse<PageInfo> getList(int pageNum, int pageSize, String keyword, HttpServletRequest request)
  {
    PageHelper.startPage(pageNum, pageSize);
    List<UserStockSubscribe> listData = this.userStockSubscribeMapper.pageList(pageNum, pageSize, keyword);
    PageInfo pageInfo = new PageInfo(listData);
    pageInfo.setList(listData);
    return ServerResponse.createBySuccess(pageInfo);
  }
  
  public ServerResponse getDetail(int id)
  {
    return ServerResponse.createBySuccess(this.userStockSubscribeMapper.load(id));
  }
  
  public ServerResponse getOneSubscribeByUserId(Integer userId, HttpServletRequest request)
  {
    return ServerResponse.createBySuccess(this.userStockSubscribeMapper.getOneSubscribeByUserId(userId));
  }
  
  public ServerResponse userSubmit(UserStockSubscribe model, HttpServletRequest request)
  {
    int ret = 0;
    if ((model != null) && (model.getId().intValue() > 0))
    {
      UserStockSubscribe userStockSubscribe = this.userStockSubscribeMapper.load(model.getId().intValue());
      if (userStockSubscribe != null)
      {
        model.setSubmitTime(DateTimeUtil.getCurrentDate());
        model.setStatus(Integer.valueOf(2));
        ret = this.userStockSubscribeMapper.update(model);
      }
      else
      {
        return ServerResponse.createByErrorMsg("新股申购订单不存在！");
      }
    }
    if (ret > 0) {
      return ServerResponse.createBySuccessMsg("操作成功");
    }
    return ServerResponse.createByErrorMsg("操作失败");
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.UserStockSubscribeServiceImpl

 * JD-Core Version:    0.7.0.1

 */