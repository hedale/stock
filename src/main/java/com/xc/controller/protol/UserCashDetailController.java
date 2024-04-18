package com.xc.controller.protol;

import com.xc.common.ServerResponse;
import com.xc.service.ISiteMessageService;
import com.xc.service.IUserCashDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/user/cash/"})
public class UserCashDetailController
{
  @Autowired
  IUserCashDetailService iUserCashDetailService;
  @Autowired
  ISiteMessageService iSiteMessageService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse list(HttpServletRequest request, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize, @RequestParam(value="positionId", required=false) Integer positionId)
  {
    return this.iUserCashDetailService.findUserCashDetailList(positionId, request, pageNum, pageSize);
  }
  
  @RequestMapping({"getMessagelist.do"})
  @ResponseBody
  public ServerResponse getMessagelist(HttpServletRequest request, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize, @RequestParam(value="userId", required=false) Integer userId)
  {
    return this.iSiteMessageService.getSiteMessageByUserIdList(pageNum, pageSize, userId.intValue(), request);
  }
  
  @RequestMapping({"updateMessageStatus.do"})
  @ResponseBody
  public ServerResponse updateMessageStatus(HttpServletRequest request)
  {
    this.iSiteMessageService.updateMessageStatus(request);
    return ServerResponse.createBySuccess("查看成功");
  }
  
  @RequestMapping({"getUnreadCount.do"})
  @ResponseBody
  public ServerResponse getUnreadCount(HttpServletRequest request)
  {
    int k = this.iSiteMessageService.getUnreadCount(request);
    return ServerResponse.createBySuccess(Integer.valueOf(k));
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.protol.UserCashDetailController

 * JD-Core Version:    0.7.0.1

 */