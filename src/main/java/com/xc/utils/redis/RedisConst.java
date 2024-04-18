package com.xc.utils.redis;

public class RedisConst
{
  public static String getAdminRedisKey(String sessionId)
  {
    return "ADMIN" + sessionId;
  }
  
  public static String getAgentRedisKey(String sessionId)
  {
    return "AGENT" + sessionId;
  }
  
  public static String getUserRedisKey(String sessionId)
  {
    return "USER" + sessionId;
  }
}


/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\
 * Qualified Name:     com.xc.utils.redis.RedisConst
 * JD-Core Version:    0.7.0.1
 */