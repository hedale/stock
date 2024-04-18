package com.xc.utils;

import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil
{
  private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
  private static Properties props;
  
  static
  {
    String fileName = "stock2guo.properties";
    props = new Properties();
    try
    {
      props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName), "UTF-8"));
    }
    catch (IOException e)
    {
      logger.error("配置文件读取异常", e);
    }
  }
  
  public static String getProperty(String key)
  {
    String value = props.getProperty(key.trim());
    if (TextUtils.isBlank(value)) {
      return null;
    }
    return value.trim();
  }
  
  public static String getProperty(String key, String defaultValue)
  {
    String value = props.getProperty(key.trim());
    if (TextUtils.isBlank(value)) {
      value = defaultValue;
    }
    return value.trim();
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.utils.PropertiesUtil

 * JD-Core Version:    0.7.0.1

 */