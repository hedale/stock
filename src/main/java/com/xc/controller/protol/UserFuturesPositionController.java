package com.xc.controller.protol;

import com.xc.common.ServerResponse;
import com.xc.service.IUserFuturesPositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/user/futures/position/"})
public class UserFuturesPositionController
{
  private static final Logger log = LoggerFactory.getLogger(UserFuturesPositionController.class);
  @Autowired
  IUserFuturesPositionService iUserFuturesPositionService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse list(HttpServletRequest request, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize, @RequestParam(value="state", required=false) Integer state, @RequestParam(value="fuName", required=false) String fuName, @RequestParam(value="fuCode", required=false) String fuCode)
  {
    return this.iUserFuturesPositionService.findMyFuturesPositionByNameAndCode(fuName, fuCode, state, request, pageNum, pageSize);
  }
  
  @RequestMapping({"findUserFuturesPositionByCode.do"})
  @ResponseBody
  public ServerResponse findUserFuturesPositionByCode(HttpServletRequest request, @RequestParam(value="futuresGid", required=false) String futuresGid)
  {
    return this.iUserFuturesPositionService.findUserFuturesPositionByCode(request, futuresGid);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.protol.UserFuturesPositionController

 * JD-Core Version:    0.7.0.1

 */