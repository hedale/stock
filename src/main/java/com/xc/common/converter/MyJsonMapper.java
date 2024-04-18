package com.xc.common.converter;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyJsonMapper
  extends ObjectMapper
{
  private static final Logger log = LoggerFactory.getLogger(MyJsonMapper.class);
  
  public MyJsonMapper()
  {
    log.info("找到不存在的值，忽略========================");
    
    configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.common.converter.MyJsonMapper

 * JD-Core Version:    0.7.0.1

 */