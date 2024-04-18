package com.xc.utils.task.stock;

import com.xc.service.IStockMarketsDayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SaveDayMarketsTask
{
  private static final Logger log = LoggerFactory.getLogger(SaveDayMarketsTask.class);
  @Autowired
  IStockMarketsDayService iStockMarketsDayService;
  
  @Scheduled(cron="0 0 16 ? * MON-FRI")
  public void banlanceUserPositionTaskV1()
  {
    dotask();
  }
  
  public void dotask()
  {
    this.iStockMarketsDayService.saveStockMarketDay();
  }
  
  @Scheduled(cron="0 0 1 * * ?")
  public void holidayTask()
  {
    this.iStockMarketsDayService.saveHoliday();
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.utils.task.stock.SaveDayMarketsTask
 * JD-Core Version:    0.7.0.1
 */