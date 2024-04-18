package com.xc.service.impl;

import com.xc.dao.SiteProductMapper;
import com.xc.dao.StockMarketsDayMapper;
import com.xc.pojo.SiteProduct;
import com.xc.pojo.Stock;
import com.xc.pojo.StockMarketsDay;
import com.xc.service.ISiteProductService;
import com.xc.service.IStockMarketsDayService;
import com.xc.service.IStockService;
import com.xc.utils.DateTimeUtil;
import com.xc.utils.HolidayUtil;
import com.xc.utils.stock.sina.SinaStockApi;
import com.xc.vo.stock.StockListVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("iStockMarketsDayService")
public class StockMarketsDayServiceImpl
  implements IStockMarketsDayService
{
  private static final Logger log = LoggerFactory.getLogger(StockMarketsDayServiceImpl.class);
  @Autowired
  IStockService iStockService;
  @Autowired
  StockMarketsDayMapper stockMarketsDayMapper;
  @Autowired
  SiteProductMapper siteProductMapper;
  @Autowired
  ISiteProductService iSiteProductService;
  
  public void saveStockMarketDay()
  {
    log.info("【保存股票日内行情 定时任务】 开始保存 ... ");
    
    List<Stock> stockList = this.iStockService.findStockList();
    for (Stock stock : stockList)
    {
      StockListVO stockListVO = SinaStockApi.assembleStockListVO(
        SinaStockApi.getSinaStock(stock.getStockGid()));
      
      Date nowDate = new Date();
      
      String ymd_date = DateTimeUtil.dateToStr(nowDate, "yyyy-MM-dd");
      
      String hm_date = DateTimeUtil.dateToStr(nowDate, "HH:mm");
      

      StockMarketsDay stockMarketsDay = new StockMarketsDay();
      
      stockMarketsDay.setStockId(stock.getId());
      
      stockMarketsDay.setStockName(stock.getStockName());
      
      stockMarketsDay.setStockCode(stock.getStockCode());
      
      stockMarketsDay.setStockGid(stock.getStockGid());
      
      stockMarketsDay.setYmd(ymd_date);
      
      stockMarketsDay.setHms(hm_date);
      
      stockMarketsDay.setNowPrice(new BigDecimal(stockListVO.getNowPrice()));
      
      stockMarketsDay.setCreaseRate(new BigDecimal(stockListVO.getHcrate().toString()));
      
      stockMarketsDay.setOpenPx(stockListVO.getOpen_px());
      
      stockMarketsDay.setClosePx(stockListVO.getPreclose_px());
      
      stockMarketsDay.setBusinessBalance(stockListVO.getBusiness_balance());
      
      stockMarketsDay.setBusinessAmount(stockListVO.getBusiness_amount());
      
      stockMarketsDay.setAddTime(nowDate);
      
      stockMarketsDay.setAddTimeStr(DateTimeUtil.dateToStr(nowDate));
      

      int insertCount = this.stockMarketsDayMapper.insert(stockMarketsDay);
      if (insertCount <= 0) {
        log.error("保存股票 {} 失败， 时间 = {}", stock.getStockName(), ymd_date);
      }
    }
  }
  
  public void saveHoliday()
  {
    log.info("【同步节假日开关 定时任务】 开始保存 ... ");
    
    SiteProduct siteProduct = this.iSiteProductService.getProductSetting();
    
    SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
    String httpArg = f.format(new Date());
    String jsonResult = HolidayUtil.request(httpArg);
    if (("1".equals(jsonResult)) || ("2".equals(jsonResult))) {
      siteProduct.setHolidayDisplay(Boolean.valueOf(true));
    } else {
      siteProduct.setHolidayDisplay(Boolean.valueOf(false));
    }
    this.siteProductMapper.updateByPrimaryKeySelective(siteProduct);
  }
  
  public BigDecimal selectRateByDaysAndStockCode(Integer stockId, int days)
  {
    return this.stockMarketsDayMapper.selectRateByDaysAndStockCode(stockId, Integer.valueOf(days));
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.service.impl.StockMarketsDayServiceImpl

 * JD-Core Version:    0.7.0.1

 */