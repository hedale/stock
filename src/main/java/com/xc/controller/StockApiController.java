package com.xc.controller;

import com.xc.common.ServerResponse;
import com.xc.service.IStockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/api/stock/"})
public class StockApiController
{
  private static final Logger log = LoggerFactory.getLogger(StockApiController.class);
  @Autowired
  IStockService iStockService;
  
  @RequestMapping({"getMarket.do"})
  @ResponseBody
  public ServerResponse getMarket()
  {
    return this.iStockService.getMarket();
  }
  
  @RequestMapping({"getStock.do"})
  @ResponseBody
  public ServerResponse getStock(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize, @RequestParam(value="stockPlate", required=false) String stockPlate, @RequestParam(value="stockType", required=false) String stockType, @RequestParam(value="keyWords", required=false) String keyWords, HttpServletRequest request)
  {
    return this.iStockService.getStock(pageNum, pageSize, keyWords, stockPlate, stockType, request);
  }
  
  @RequestMapping({"getSingleStock.do"})
  @ResponseBody
  public ServerResponse getSingleStock(@RequestParam("code") String code)
  {
    return this.iStockService.getSingleStock(code);
  }
  
  @RequestMapping({"getMinK.do"})
  @ResponseBody
  public ServerResponse getMinK(@RequestParam("code") String code, @RequestParam("time") Integer time, @RequestParam("ma") Integer ma, @RequestParam("size") Integer size)
  {
    return this.iStockService.getMinK(code, time, ma, size);
  }
  
  @RequestMapping({"getDayK.do"})
  @ResponseBody
  public ServerResponse getDayK(@RequestParam("code") String code)
  {
    return this.iStockService.getDayK_Echarts(code);
  }
  
  @RequestMapping({"getMinK_Echarts.do"})
  @ResponseBody
  public ServerResponse getMinK_Echarts(@RequestParam("code") String code, @RequestParam("time") Integer time, @RequestParam("ma") Integer ma, @RequestParam("size") Integer size)
  {
    return this.iStockService.getMinK_Echarts(code, time, ma, size);
  }
  
  @RequestMapping({"getFuturesMinK_Echarts.do"})
  @ResponseBody
  public ServerResponse getFuturesMinK_Echarts(@RequestParam("code") String code, @RequestParam("time") Integer time, @RequestParam("size") Integer size)
  {
    return this.iStockService.getFuturesMinK_Echarts(code, time, size);
  }
  
  @RequestMapping({"getIndexMinK_Echarts.do"})
  @ResponseBody
  public ServerResponse getIndexMinK_Echarts(@RequestParam("code") String code, @RequestParam("time") Integer time, @RequestParam("size") Integer size)
  {
    return this.iStockService.getIndexMinK_Echarts(code, time, size);
  }
  
  @RequestMapping({"getFuturesDayK.do"})
  @ResponseBody
  public ServerResponse getFuturesDayK(@RequestParam("code") String code)
  {
    return this.iStockService.getFuturesDayK(code);
  }
  
  @RequestMapping({"getIndexDayK.do"})
  @ResponseBody
  public ServerResponse getIndexDayK(@RequestParam("code") String code)
  {
    return this.iStockService.getIndexDayK(code);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.controller.StockApiController

 * JD-Core Version:    0.7.0.1

 */