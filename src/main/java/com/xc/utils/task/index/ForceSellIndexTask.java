package com.xc.utils.task.index;

import com.xc.service.IUserService;
import com.xc.utils.DateTimeUtil;
import com.xc.utils.stock.BuyAndSellUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ForceSellIndexTask
{
  private static final Logger log = LoggerFactory.getLogger(ForceSellIndexTask.class);
  @Autowired
  IUserService iUserService;
  private static final String am_begin = "9:30";
  private static final String am_end = "11:30";
  private static final String pm_begin = "13:00";
  private static final String pm_end = "15:00";
  
  @Scheduled(cron="0 0/3 9-15 ? * MON-FRI")
  public void banlanceUserIndexPositionTaskV1()
  {
    boolean am = false;
    boolean pm = false;
    try
    {
      am = BuyAndSellUtils.isTransTime("9:30", "11:30");
      pm = BuyAndSellUtils.isTransTime("13:00", "15:00");
    }
    catch (Exception e)
    {
      log.error("执行定时任务（指数）出错，e = {}", e);
    }
    log.info("当前 am = {}  pm = {}", Boolean.valueOf(am), Boolean.valueOf(pm));
    if ((am) || (pm))
    {
      log.info("=====扫描用户（指数）持仓执行，当前时间 {} =====", DateTimeUtil.dateToStr(new Date()));
      dotask();
      log.info("=====扫描用户（指数）持仓结束，当前时间 {} =====", DateTimeUtil.dateToStr(new Date()));
    }
    else
    {
      log.info("当前时间不为周一至周五，或者不在交易时间内，不执行（强平指数）定时任务");
    }
  }
  
  public void dotask()
  {
    this.iUserService.ForceSellIndexTask();
  }
  
  @Scheduled(cron="0 0/3 9-15 ? * MON-FRI")
  public void banlanceUserIndexPositionMessage()
  {
    boolean am = false;
    boolean pm = false;
    try
    {
      am = BuyAndSellUtils.isTransTime("9:30", "11:30");
      pm = BuyAndSellUtils.isTransTime("13:00", "15:00");
    }
    catch (Exception e)
    {
      log.error("执行定时任务（指数）出错，e = {}", e);
    }
    log.info("当前 am = {}  pm = {}", Boolean.valueOf(am), Boolean.valueOf(pm));
    if ((am) || (pm))
    {
      log.info("=====扫描用户（指数）持仓执行，当前时间 {} =====", DateTimeUtil.dateToStr(new Date()));
      this.iUserService.ForceSellIndexsMessageTask();
      log.info("=====扫描用户（指数）持仓结束，当前时间 {} =====", DateTimeUtil.dateToStr(new Date()));
    }
    else
    {
      log.info("当前时间不为周一至周五，或者不在交易时间内，不执行（强平指数）定时任务");
    }
  }
  
  @Scheduled(cron="0 0/1 9-15 * * ?")
  public void zs1()
  {
    boolean am = false;
    boolean pm = false;
    try
    {
      am = BuyAndSellUtils.isTransTime("9:29", "11:31");
      pm = BuyAndSellUtils.isTransTime("12:59", "15:00");
    }
    catch (Exception e)
    {
      log.error("= {}", e);
    }
    log.info("zs1-am = {}  pm = {}", Boolean.valueOf(am), Boolean.valueOf(pm));
    if ((am) || (pm))
    {
      log.info("====={} =====", DateTimeUtil.dateToStr(new Date()));
      this.iUserService.zs1();
      log.info("====={} =====", DateTimeUtil.dateToStr(new Date()));
    }
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.utils.task.index.ForceSellIndexTask

 * JD-Core Version:    0.7.0.1

 */