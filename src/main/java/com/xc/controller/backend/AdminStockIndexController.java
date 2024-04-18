package com.xc.controller.backend;

import com.xc.common.ServerResponse;
import com.xc.pojo.StockIndex;
import com.xc.service.IStockIndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/admin/index/"})
public class AdminStockIndexController
{
  private static final Logger log = LoggerFactory.getLogger(AdminStockIndexController.class);
  @Autowired
  IStockIndexService iStockIndexService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse list(@RequestParam(value="homeShow", required=false) Integer homeShow, @RequestParam(value="listShow", required=false) Integer listShow, @RequestParam(value="transState", required=false) Integer transState, @RequestParam(value="indexCode", required=false) String indexCode, @RequestParam(value="indexName", required=false) String indexName, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize, HttpServletRequest request)
  {
    return this.iStockIndexService.listByAdmin(homeShow, listShow, transState, indexCode, indexName, pageNum, pageSize, request);
  }
  
  @RequestMapping({"updateIndex.do"})
  @ResponseBody
  public ServerResponse updateIndex(StockIndex stockIndex)
  {
    return this.iStockIndexService.updateIndex(stockIndex);
  }
  
  @RequestMapping({"addIndex.do"})
  @ResponseBody
  public ServerResponse addIndex(StockIndex stockIndex)
  {
    return this.iStockIndexService.addIndex(stockIndex);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.backend.AdminStockIndexController

 * JD-Core Version:    0.7.0.1

 */