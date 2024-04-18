package com.xc.dao;

import com.xc.pojo.SiteFuturesSetting;

import java.util.List;

public abstract interface SiteFuturesSettingMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(SiteFuturesSetting paramSiteFuturesSetting);
  
  public abstract int insertSelective(SiteFuturesSetting paramSiteFuturesSetting);
  
  public abstract SiteFuturesSetting selectByPrimaryKey(Integer paramInteger);
  
  public abstract int updateByPrimaryKeySelective(SiteFuturesSetting paramSiteFuturesSetting);
  
  public abstract int updateByPrimaryKey(SiteFuturesSetting paramSiteFuturesSetting);
  
  public abstract List selectAllSiteSetting();
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.dao.SiteFuturesSettingMapper

 * JD-Core Version:    0.7.0.1

 */