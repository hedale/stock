package com.xc.utils.stock.sina;

import com.xc.common.ServerResponse;
import com.xc.pojo.Stock;
import com.xc.pojo.StockFutures;
import com.xc.pojo.StockIndex;
import com.xc.utils.HttpClientRequest;
import com.xc.utils.PropertiesUtil;
import com.xc.utils.redis.JsonUtil;
import com.xc.utils.stock.sina.vo.SinaStockMinData;
import com.xc.vo.stock.StockListVO;
import com.xc.vo.stock.StockVO;
import com.xc.vo.stock.k.MinDataVO;
import com.xc.vo.stock.k.echarts.EchartsDataVO;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

public class SinaStockApi
{
  public static final String sina_url = PropertiesUtil.getProperty("sina.single.stock.url");
  private static final Logger log = LoggerFactory.getLogger(SinaStockApi.class);
  
  public static String getSinaStock(String stockGid)
  {
    String sina_result = "";
    try
    {
      sina_result = HttpClientRequest.doGet(sina_url + stockGid);
    }
    catch (Exception e)
    {
      log.error("获取股票行情出错，错误信息 = {}", e);
    }
    return sina_result.substring(sina_result.indexOf("=") + 2);
  }
  
  public static StockListVO assembleStockListVO(String sinaResult)
  {
    StockListVO stockListVO = new StockListVO();
    
    String[] hqarr = sinaResult.split(",");
    if (hqarr.length > 1)
    {
      stockListVO.setName(hqarr[0]);
      
      stockListVO.setNowPrice(hqarr[3]);
      
      BigDecimal chang_rate = new BigDecimal("0");
      if ((new BigDecimal(hqarr[2]).compareTo(new BigDecimal("0")) != 0) && (new BigDecimal(hqarr[3]).compareTo(new BigDecimal("0")) != 0))
      {
        chang_rate = new BigDecimal(hqarr[3]).subtract(new BigDecimal(hqarr[2]));
        
        chang_rate = chang_rate.multiply(new BigDecimal("100")).divide(new BigDecimal(hqarr[2]), 2, RoundingMode.HALF_UP);
      }
      stockListVO.setHcrate(chang_rate);
      
      stockListVO.setToday_max(hqarr[4]);
      
      stockListVO.setToday_min(hqarr[5]);
      
      stockListVO.setBusiness_amount(hqarr[8]);
      
      stockListVO.setBusiness_balance(hqarr[9]);
      
      stockListVO.setPreclose_px(hqarr[2]);
      
      stockListVO.setOpen_px(hqarr[1]);
    }
    return stockListVO;
  }
  
  public static StockVO assembleStockVO(String sinaResult)
  {
    StockVO stockVO = new StockVO();
    
    String[] hqarr = sinaResult.split(",");
    
    stockVO.setName(hqarr[0]);
    
    stockVO.setNowPrice(hqarr[3]);
    
    BigDecimal chang_rate = new BigDecimal("0");
    if ((new BigDecimal(hqarr[2]).compareTo(new BigDecimal("0")) != 0) && (new BigDecimal(hqarr[3]).compareTo(new BigDecimal("0")) != 0))
    {
      chang_rate = new BigDecimal(hqarr[3]).subtract(new BigDecimal(hqarr[2]));
      
      chang_rate = chang_rate.multiply(new BigDecimal("100")).divide(new BigDecimal(hqarr[2]), 2, RoundingMode.HALF_UP);
    }
    stockVO.setHcrate(chang_rate);
    
    stockVO.setToday_max(hqarr[4]);
    
    stockVO.setToday_min(hqarr[5]);
    
    stockVO.setBusiness_amount(hqarr[8]);
    
    stockVO.setBusiness_balance(hqarr[9]);
    
    stockVO.setPreclose_px(hqarr[2]);
    
    stockVO.setOpen_px(hqarr[1]);
    
    stockVO.setBuy1(hqarr[6]);
    stockVO.setBuy2(hqarr[13]);
    stockVO.setBuy3(hqarr[15]);
    stockVO.setBuy4(hqarr[17]);
    stockVO.setBuy5(hqarr[19]);
    
    stockVO.setSell1(hqarr[7]);
    stockVO.setSell2(hqarr[23]);
    stockVO.setSell3(hqarr[25]);
    stockVO.setSell4(hqarr[27]);
    stockVO.setSell5(hqarr[29]);
    
    stockVO.setBuy1_num(hqarr[10]);
    stockVO.setBuy2_num(hqarr[12]);
    stockVO.setBuy3_num(hqarr[14]);
    stockVO.setBuy4_num(hqarr[16]);
    stockVO.setBuy5_num(hqarr[18]);
    
    stockVO.setSell1_num(hqarr[20]);
    stockVO.setSell2_num(hqarr[22]);
    stockVO.setSell3_num(hqarr[24]);
    stockVO.setSell4_num(hqarr[26]);
    stockVO.setSell5_num(hqarr[28]);
    
    return stockVO;
  }
  
  public static StockVO assembleStockFuturesVO(String sinaResult)
  {
    StockVO stockVO = new StockVO();
    
    String[] hqarr = sinaResult.split(",");
    if (hqarr.length <= 14)
    {
      String sinaResulttemp = sinaResult.replace("\"", ",1\"");
      hqarr = sinaResulttemp.split(",");
    }
    stockVO.setName(hqarr[13]);
    
    stockVO.setNowPrice(hqarr[0]);
    
    BigDecimal rates = new BigDecimal("0");
    BigDecimal b1 = new BigDecimal(hqarr[3].toString());
    BigDecimal b2 = new BigDecimal(hqarr[2].toString());
    BigDecimal b3 = b1.subtract(b2);
    String s = hqarr[14].toString();
    int index = s.indexOf("\"");
    String substring = s.substring(0, index);
    rates = b3.multiply(new BigDecimal("100")).divide(b1, 2, 4);
    stockVO.setHcrate(rates);
    
    stockVO.setToday_max(hqarr[7]);
    
    stockVO.setToday_min(hqarr[8]);
    
    stockVO.setBusiness_amount(substring);
    
    stockVO.setBusiness_balance(hqarr[9]);
    
    stockVO.setPreclose_px(hqarr[11]);
    
    stockVO.setOpen_px(hqarr[10]);
    
    stockVO.setBuy1(hqarr[2]);
    stockVO.setBuy2("0");
    stockVO.setBuy3("0");
    stockVO.setBuy4("0");
    stockVO.setBuy5("0");
    
    stockVO.setSell1(hqarr[3]);
    stockVO.setSell2("0");
    stockVO.setSell3("0");
    stockVO.setSell4("0");
    stockVO.setSell5("0");
    
    stockVO.setBuy1_num(hqarr[10]);
    stockVO.setBuy2_num("0");
    stockVO.setBuy3_num("0");
    stockVO.setBuy4_num("0");
    stockVO.setBuy5_num("0");
    
    stockVO.setSell1_num(hqarr[11]);
    stockVO.setSell2_num("0");
    stockVO.setSell3_num("0");
    stockVO.setSell4_num("0");
    stockVO.setSell5_num("0");
    
    return stockVO;
  }
  
  public static ServerResponse<MinDataVO> getStockMinK(Stock stock, int time, int ma, int size)
  {
    int maxSize = Integer.parseInt(PropertiesUtil.getProperty("sina.k.min.max.size"));
    if (size > maxSize) {
      size = maxSize;
    }
    String minUrl = PropertiesUtil.getProperty("sina.k.min.url");
    minUrl = minUrl + "?symbol=" + stock.getStockGid() + "&scale=" + time + "&ma=" + ma + "&datalen=" + size;
    
    String hqstr = "";
    try
    {
      hqstr = HttpClientRequest.doGet(minUrl);
    }
    catch (Exception e)
    {
      log.error("获取股票K线分时图出错，错误信息 = {}", e);
    }
    log.info(" time = {} ma = {} size = {}", new Object[] { Integer.valueOf(time), Integer.valueOf(ma), Integer.valueOf(size) });
    

    hqstr = hqstr.replace("day", "\"day\"").replace("open", "\"open\"").replace("high", "\"high\"").replace("low", "\"low\"").replace("close", "\"close\"");
    if (ma == 5) {
      hqstr = hqstr.replace("ma_volume5", "\"ma_volume\"").replace(",volume", ",\"volume\"").replace("ma_price5", "\"ma_price\"");
    } else if (ma == 10) {
      hqstr = hqstr.replace("ma_volume10", "\"ma_volume\"").replace(",volume", ",\"volume\"").replace("ma_price10", "\"ma_price\"");
    } else if (ma == 15) {
      hqstr = hqstr.replace("ma_volume15", "\"ma_volume\"").replace(",volume", ",\"volume\"").replace("ma_price15", "\"ma_price\"");
    } else {
      return ServerResponse.createByErrorMsg("ma 取值 5，10，15");
    }
    if (StringUtils.isBlank(hqstr)) {
      return ServerResponse.createByErrorMsg("没有查询到行情数据");
    }
    MinDataVO minDataVO = new MinDataVO();
    minDataVO.setStockName(stock.getStockName());
    minDataVO.setStockCode(stock.getStockCode());
    minDataVO.setGid(stock.getStockGid());
    
    hqstr = hqstr.replaceAll("\"\"", "\"");
    
    List<SinaStockMinData> list = (List)JsonUtil.string2Obj(hqstr, new TypeReference() {});
    log.info("需要查询的行情size为： {}", Integer.valueOf(size));
    
    minDataVO.setData(list);
    
    return ServerResponse.createBySuccess(minDataVO);
  }
  
  public static ServerResponse<MinDataVO> getFuturesMinK(StockFutures stock, int time, int size)
  {
    String minUrl = PropertiesUtil.getProperty("sina.futures.k.min.url").replace("{code}", stock.getFuturesCode()).replace("{time}", String.valueOf(time));
    String stamp = String.valueOf(new Date().getTime());
    minUrl = minUrl.replace("{stamp}", stamp);
    
    String hqstr = "";
    try
    {
      hqstr = HttpClientRequest.doGet(minUrl);
    }
    catch (Exception e)
    {
      log.error("获取股票K线分时图出错，错误信息 = {}", e);
    }
    log.info("期货分时 - time = {} ", Integer.valueOf(time));
    
    hqstr = hqstr.split("\\[")[1].replace("]);", "");
    hqstr = hqstr.replace("d", "\"day\"");
    hqstr = hqstr.replace("o", "\"open\"");
    hqstr = hqstr.replace("h", "\"high\"");
    hqstr = hqstr.replace("l", "\"low\"");
    hqstr = hqstr.replace("c", "\"close\"");
    hqstr = hqstr.replace("v", "\"volume\"");
    if (StringUtils.isBlank(hqstr)) {
      return ServerResponse.createByErrorMsg("没有查询到行情数据");
    }
    MinDataVO minDataVO = new MinDataVO();
    minDataVO.setStockName(stock.getFuturesName());
    minDataVO.setStockCode(stock.getFuturesCode());
    minDataVO.setGid(stock.getFuturesGid());
    
    hqstr = hqstr.replaceAll("\"\"", "\"");
    hqstr = "[" + hqstr + "]";
    
    List<SinaStockMinData> list = (List)JsonUtil.string2Obj(hqstr, new TypeReference() {});
    if (list.size() > size) {
      list = list.subList(list.size() - size - 1, list.size());
    }
    minDataVO.setData(list);
    return ServerResponse.createBySuccess(minDataVO);
  }
  
  public static EchartsDataVO assembleEchartsDataVO(MinDataVO minDataVO)
  {
    EchartsDataVO echartsDataVO = new EchartsDataVO();
    echartsDataVO.setStockName(minDataVO.getStockName());
    echartsDataVO.setStockCode(minDataVO.getStockCode());
    
    List<SinaStockMinData> minDataList = minDataVO.getData();
    

    double[][] values = (double[][])null;
    Object[][] volumes = (Object[][])null;
    String[] date = null;
    if (minDataList.size() > 0)
    {
      values = new double[minDataList.size()][5];
      
      volumes = new Object[minDataList.size()][3];
      
      date = new String[minDataList.size()];
      for (int i = 0; i < minDataList.size(); i++)
      {
        SinaStockMinData sinaStockMinData = (SinaStockMinData)minDataList.get(i);
        for (int j = 0; j < values[i].length; j++)
        {
          values[i][0] = Double.valueOf(sinaStockMinData.getOpen()).doubleValue();
          values[i][1] = Double.valueOf(sinaStockMinData.getClose()).doubleValue();
          values[i][2] = Double.valueOf(sinaStockMinData.getLow()).doubleValue();
          values[i][3] = Double.valueOf(sinaStockMinData.getHigh()).doubleValue();
          values[i][4] = Double.valueOf(sinaStockMinData.getVolume()).doubleValue();
        }
        for (int k = 0; k < volumes[i].length; k++)
        {
          volumes[i][0] = Integer.valueOf(i);
          volumes[i][1] = Double.valueOf(sinaStockMinData.getVolume());
          if (new BigDecimal(sinaStockMinData.getClose()).compareTo(new BigDecimal(sinaStockMinData.getOpen())) == 1) {
            volumes[i][2] = Integer.valueOf(1);
          } else {
            volumes[i][2] = Integer.valueOf(-1);
          }
        }
        date[i] = sinaStockMinData.getDay();
      }
    }
    echartsDataVO.setValues(values);
    echartsDataVO.setVolumes(volumes);
    echartsDataVO.setDate(date);
    
    return echartsDataVO;
  }
  
  public static ServerResponse<MinDataVO> getStockDayK(Stock stock, int time, int ma, int size)
  {
    int maxSize = Integer.parseInt(PropertiesUtil.getProperty("sina.k.min.max.size"));
    if (size > maxSize) {
      size = maxSize;
    }
    String minUrl = PropertiesUtil.getProperty("sina.k.min.url");
    minUrl = minUrl + "?symbol=" + stock.getStockGid() + "&scale=" + time + "&ma=" + ma + "&datalen=" + size;
    
    String hqstr = "";
    try
    {
      hqstr = HttpClientRequest.doGet(minUrl);
    }
    catch (Exception e)
    {
      log.error("获取股票K线分时图出错，错误信息 = {}", e);
    }
    log.info(" time = {} ma = {} size = {}", new Object[] { Integer.valueOf(time), Integer.valueOf(ma), Integer.valueOf(size) });
    

    hqstr = hqstr.replace("day", "\"day\"").replace("open", "\"open\"").replace("high", "\"high\"").replace("low", "\"low\"").replace("close", "\"close\"");
    if (ma == 5) {
      hqstr = hqstr.replace("ma_volume5", "\"ma_volume\"").replace(",volume", ",\"volume\"").replace("ma_price5", "\"ma_price\"");
    } else if (ma == 10) {
      hqstr = hqstr.replace("ma_volume10", "\"ma_volume\"").replace(",volume", ",\"volume\"").replace("ma_price10", "\"ma_price\"");
    } else if (ma == 15) {
      hqstr = hqstr.replace("ma_volume15", "\"ma_volume\"").replace(",volume", ",\"volume\"").replace("ma_price15", "\"ma_price\"");
    } else {
      return ServerResponse.createByErrorMsg("ma 取值 5，10，15");
    }
    if (StringUtils.isBlank(hqstr)) {
      return ServerResponse.createByErrorMsg("没有查询到行情数据");
    }
    MinDataVO minDataVO = new MinDataVO();
    minDataVO.setStockName(stock.getStockName());
    minDataVO.setStockCode(stock.getStockCode());
    minDataVO.setGid(stock.getStockGid());
    
    hqstr = hqstr.replaceAll("\"\"", "\"");
    
    List<SinaStockMinData> list = (List)JsonUtil.string2Obj(hqstr, new TypeReference() {});
    log.info("需要查询的行情size为： {}", Integer.valueOf(size));
    
    minDataVO.setData(list);
    
    return ServerResponse.createBySuccess(minDataVO);
  }
  
  public static ServerResponse<MinDataVO> getIndexMinK(StockIndex stock, int time, int size)
  {
    String minUrl = PropertiesUtil.getProperty("sina.index.k.min.url").replace("{code}", stock.getIndexGid()).replace("{time}", String.valueOf(time));
    String stamp = String.valueOf(new Date().getTime());
    minUrl = minUrl.replace("{stamp}", stamp);
    
    String hqstr = "";
    try
    {
      hqstr = HttpClientRequest.doGet(minUrl);
    }
    catch (Exception e)
    {
      log.error("获取股票K线分时图出错，错误信息 = {}", e);
    }
    log.info("期货分时 - time = {} ", Integer.valueOf(time));
    
    hqstr = hqstr.split("\\[")[1].replace("]);", "");
    if (StringUtils.isBlank(hqstr)) {
      return ServerResponse.createByErrorMsg("没有查询到行情数据");
    }
    MinDataVO minDataVO = new MinDataVO();
    minDataVO.setStockName(stock.getIndexName());
    minDataVO.setStockCode(stock.getIndexCode());
    minDataVO.setGid(stock.getIndexGid());
    
    hqstr = hqstr.replaceAll("\"\"", "\"");
    hqstr = "[" + hqstr + "]";
    
    List<SinaStockMinData> list = (List)JsonUtil.string2Obj(hqstr, new TypeReference() {});
    if (list.size() > size) {
      list = list.subList(list.size() - size - 1, list.size());
    }
    minDataVO.setData(list);
    return ServerResponse.createBySuccess(minDataVO);
  }
  
  public static void main(String[] args)
  {
    getSinaStock("s_sh600090");
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.utils.stock.sina.SinaStockApi

 * JD-Core Version:    0.7.0.1

 */