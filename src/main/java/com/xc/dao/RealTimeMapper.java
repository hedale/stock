package com.xc.dao;

import com.xc.pojo.RealTime;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public abstract interface RealTimeMapper
{
  @Select({"select * from realtime where stockCode=#{stockCode}"})
  public abstract List<RealTime> findStock(String paramString);
  
  @Delete({"DELETE FROM realtime WHERE locate('hf_',`stockCode`)=0"})
  public abstract int deleteStockCode();
  
  @Delete({"DELETE FROM realtime WHERE locate('hf_',`stockCode`)=1"})
  public abstract int deleteStockFuturesCode();
  
  @Insert({"<script>", "insert into realtime (time,volumes,price,rates,averagePrice,amounts,stockCode) values ", "<foreach  collection='areaLists' item='realTime' index='index' separator=','>", "(#{realTime.time},#{realTime.volumes},#{realTime.price},#{realTime.rates},#{realTime.averagePrice},#{realTime.amounts},#{realTime.stockCode})", "</foreach>", "</script>"})
  public abstract int insertRealTime(@Param("areaLists") List<RealTime> paramList);
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.RealTimeMapper

 * JD-Core Version:    0.7.0.1

 */