package com.xc.controller.backend;

import com.xc.common.ServerResponse;
import com.xc.pojo.FundsDealerInstitutions;
import com.xc.pojo.FundsSecuritiesInfo;
import com.xc.pojo.FundsTradingAccount;
import com.xc.service.IFundsDealerInstitutionsService;
import com.xc.service.IFundsSecuritiesInfoService;
import com.xc.service.IFundsTradingAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/admin/funds/dealer"})
public class AdminFundsDealerInstitutionsController
{
  private static final Logger log = LoggerFactory.getLogger(AdminAgentController.class);
  @Autowired
  IFundsDealerInstitutionsService iFundsDealerInstitutionsService;
  @Autowired
  IFundsSecuritiesInfoService iFundsSecuritiesInfoService;
  @Autowired
  IFundsTradingAccountService iFundsTradingAccountService;
  
  @RequestMapping({"getDealerInstitutionsList.do"})
  @ResponseBody
  public ServerResponse getFundsDealerInstitutionsList(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="12") int pageSize, @RequestParam(value="keyword", defaultValue="") String keyword, @RequestParam(value="status", required=false) Integer status, HttpServletRequest request)
  {
    return ServerResponse.createBySuccess(this.iFundsDealerInstitutionsService.getList(pageNum, pageSize, keyword, status, request));
  }
  
  @RequestMapping({"saveDealerInstitutions.do"})
  @ResponseBody
  public ServerResponse saveFundsDealerInstitutions(FundsDealerInstitutions fundsDealerInstitutions)
  {
    return ServerResponse.createBySuccess(this.iFundsDealerInstitutionsService.save(fundsDealerInstitutions));
  }
  
  @RequestMapping({"getSecuritiesInfoList.do"})
  @ResponseBody
  public ServerResponse getSecuritiesInfoList(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="12") int pageSize, @RequestParam(value="keyword", defaultValue="") String keyword, HttpServletRequest request)
  {
    return ServerResponse.createBySuccess(this.iFundsSecuritiesInfoService.getList(pageNum, pageSize, keyword, request));
  }
  
  @RequestMapping({"saveSecuritiesInfo.do"})
  @ResponseBody
  public ServerResponse saveSecuritiesInfo(FundsSecuritiesInfo model)
  {
    return ServerResponse.createBySuccess(this.iFundsSecuritiesInfoService.save(model));
  }
  
  @RequestMapping({"getSecuritiesEnabledList.do"})
  @ResponseBody
  public ServerResponse getSecuritiesEnabledList()
  {
    return ServerResponse.createBySuccess(this.iFundsSecuritiesInfoService.getEnabledList());
  }
  
  @RequestMapping({"getTradingAccountList.do"})
  @ResponseBody
  public ServerResponse getTradingAccountList(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="12") int pageSize, @RequestParam(value="keyword", defaultValue="") String keyword, @RequestParam(value="status", required=false) Integer status, HttpServletRequest request)
  {
    return ServerResponse.createBySuccess(this.iFundsTradingAccountService.getList(pageNum, pageSize, keyword, status, request));
  }
  
  @RequestMapping({"saveTradingAccount.do"})
  @ResponseBody
  public ServerResponse saveTradingAccount(FundsTradingAccount model)
  {
    return ServerResponse.createBySuccess(this.iFundsTradingAccountService.save(model));
  }
  
  @RequestMapping({"getMaxNumber.do"})
  @ResponseBody
  public ServerResponse getMaxNumber()
  {
    return this.iFundsTradingAccountService.getMaxNumber();
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.backend.AdminFundsDealerInstitutionsController

 * JD-Core Version:    0.7.0.1

 */