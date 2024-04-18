package com.xc.controller.backend;

import com.xc.common.ServerResponse;
import com.xc.pojo.StockCoin;
import com.xc.service.IStockCoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/admin/coin/"})
public class AdminStockCoinController
{
  private static final Logger log = LoggerFactory.getLogger(AdminStockCoinController.class);
  @Autowired
  IStockCoinService iStockCoinService;
  
  @RequestMapping({"list.do"})
  @ResponseBody
  public ServerResponse list(@RequestParam(value="coinName", required=false) String coinName, @RequestParam(value="coinCode", required=false) String coinCode, @RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="pageSize", defaultValue="10") int pageSize)
  {
    return this.iStockCoinService.listByAdmin(coinName, coinCode, pageNum, pageSize);
  }
  
  @RequestMapping({"add.do"})
  @ResponseBody
  public ServerResponse add(StockCoin stockCoin)
  {
    return this.iStockCoinService.add(stockCoin);
  }
  
  @RequestMapping({"update.do"})
  @ResponseBody
  public ServerResponse update(StockCoin stockCoin)
  {
    return this.iStockCoinService.update(stockCoin);
  }
  
  @RequestMapping({"getSelectCoin.do"})
  @ResponseBody
  public ServerResponse getSelectCoin()
  {
    return ServerResponse.createBySuccess(this.iStockCoinService.getSelectCoin());
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.controller.backend.AdminStockCoinController
 * JD-Core Version:    0.7.0.1
 */