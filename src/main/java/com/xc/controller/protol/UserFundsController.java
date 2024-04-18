package com.xc.controller.protol;

import com.xc.common.ServerResponse;
import com.xc.pojo.FundsAppend;
import com.xc.pojo.FundsApply;
import com.xc.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/user/funds/"})
public class UserFundsController
{
  private static final Logger log = LoggerFactory.getLogger(UserFundsController.class);
  @Autowired
  IFundsSettingService iFundsSettingService;
  @Autowired
  IFundsLeverService iFundsLeverService;
  @Autowired
  IFundsApplyService iFundsApplyService;
  @Autowired
  IUserFundsPositionService iUserFundsPositionService;
  @Autowired
  IFundsAppendService iFundsAppendService;
  
  @RequestMapping({"getFundsSetting.do"})
  @ResponseBody
  public ServerResponse getFundsSetting()
  {
    return ServerResponse.createBySuccess(this.iFundsSettingService.getFundsSetting());
  }
  
  @RequestMapping({"getFundsTypeList.do"})
  @ResponseBody
  public ServerResponse getFundsTypeList(Integer cycleType)
  {
    return this.iFundsLeverService.getFundsTypeList(cycleType);
  }
  
  @RequestMapping({"addFundsApply.do"})
  @ResponseBody
  public ServerResponse addFundsApply(FundsApply fundsApply, HttpServletRequest request)
    throws Exception
  {
    return this.iFundsApplyService.insert(fundsApply, request);
  }
  
  @RequestMapping({"getUserApplyList.do"})
  @ResponseBody
  public ServerResponse getUserApplyList(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="12") int pageSize, @RequestParam(value="userId", defaultValue="") int userId, HttpServletRequest request)
  {
    return this.iFundsApplyService.getUserApplyList(pageNum, pageSize, userId, request);
  }
  
  @RequestMapping({"getUserSubaccount.do"})
  @ResponseBody
  public ServerResponse getUserSubaccount(HttpServletRequest request)
  {
    return this.iFundsApplyService.getUserEnabledSubaccount(request);
  }
  
  @RequestMapping({"buyFunds.do"})
  @ResponseBody
  public ServerResponse buyFunds(Integer stockId, Integer buyNum, Integer buyType, Integer lever, Integer subaccountNumber, HttpServletRequest request)
  {
    ServerResponse serverResponse = null;
    try
    {
      serverResponse = this.iUserFundsPositionService.buyFunds(stockId, buyNum, buyType, lever, subaccountNumber, request);
    }
    catch (Exception e)
    {
      log.error("用户下单操作 = {}", e);
    }
    return serverResponse;
  }
  
  @RequestMapping({"sellFunds.do"})
  @ResponseBody
  public ServerResponse sellFunds(HttpServletRequest request, @RequestParam("positionSn") String positionSn)
  {
    ServerResponse serverResponse = null;
    try
    {
      serverResponse = this.iUserFundsPositionService.sellFunds(positionSn, 1);
    }
    catch (Exception e)
    {
      log.error("用户平仓操作 = {}", e);
    }
    return serverResponse;
  }
  
  @RequestMapping({"fundsList.do"})
  @ResponseBody
  public ServerResponse fundsList(HttpServletRequest request, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize, @RequestParam(value="state", required=false) Integer state, @RequestParam(value="stockCode", required=false) String stockCode, @RequestParam(value="stockSpell", required=false) String stockSpell)
  {
    return this.iUserFundsPositionService.findMyPositionByCodeAndSpell(stockCode, stockSpell, state, request, pageNum, pageSize);
  }
  
  @RequestMapping({"getSubaccountInfo.do"})
  @ResponseBody
  public ServerResponse getSubaccountInfo(Integer id)
  {
    return this.iFundsApplyService.getDetail(id.intValue());
  }
  
  @RequestMapping({"getLeverRateInfo.do"})
  @ResponseBody
  public ServerResponse getLeverRateInfo(Integer cycleType, Integer lever)
  {
    return this.iFundsLeverService.getLeverRateInfo(cycleType, lever);
  }
  
  @RequestMapping({"appendApply.do"})
  @ResponseBody
  public ServerResponse appendApply(FundsAppend fundsApply, HttpServletRequest request)
    throws Exception
  {
    return this.iFundsAppendService.save(fundsApply, request);
  }
  
  @RequestMapping({"getAppendList.do"})
  @ResponseBody
  public ServerResponse getAppendList(HttpServletRequest request, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize, @RequestParam(value="keyword", required=false) String keyword, @RequestParam(value="status", required=false) Integer status, @RequestParam(value="userId", required=false) Integer userId, @RequestParam(value="appendType", required=false) Integer appendType)
  {
    return this.iFundsAppendService.getList(pageNum, pageSize, keyword, status, userId, appendType, request);
  }
  
  @RequestMapping({"findUserFundsPositionByCode.do"})
  @ResponseBody
  public ServerResponse findUserFundsPositionByCode(HttpServletRequest request, @RequestParam(value="fundsCode", required=false) String fundsCode)
  {
    return this.iUserFundsPositionService.findUserFundsPositionByCode(request, fundsCode);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.protol.UserFundsController

 * JD-Core Version:    0.7.0.1

 */