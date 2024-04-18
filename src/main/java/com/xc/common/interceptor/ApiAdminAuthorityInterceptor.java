package com.xc.common.interceptor;

import com.google.common.collect.Maps;
import com.xc.pojo.SiteAdmin;
import com.xc.utils.PropertiesUtil;
import com.xc.utils.redis.CookieUtils;
import com.xc.utils.redis.JsonUtil;
import com.xc.utils.redis.RedisShardedPoolUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class ApiAdminAuthorityInterceptor
  implements HandlerInterceptor
{
  private static final Logger log = LoggerFactory.getLogger(ApiAdminAuthorityInterceptor.class);
  
  public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler)
    throws Exception
  {
    SiteAdmin siteAdmin = null;
    String loginToken = CookieUtils.readLoginToken(httpServletRequest, 
      PropertiesUtil.getProperty("admin.cookie.name"));
    if (StringUtils.isNotEmpty(loginToken))
    {
      String adminJsonStr = RedisShardedPoolUtils.get(loginToken);
      siteAdmin = (SiteAdmin)JsonUtil.string2Obj(adminJsonStr, SiteAdmin.class);
    }
    if (null == siteAdmin)
    {
      httpServletResponse.reset();
      httpServletResponse.setCharacterEncoding("UTF-8");
      httpServletResponse.setContentType("application/json;charset=UTF-8");
      PrintWriter writer = httpServletResponse.getWriter();
      Map map = Maps.newHashMap();
      map.put("success", Boolean.valueOf(false));
      map.put("msg", "请先登录，无权限访问admin");
      writer.print(JsonUtil.obj2String(map));
      writer.flush();
      writer.close();
      return false;
    }
    return true;
  }
  
  public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView)
    throws Exception
  {}
  
  public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e)
    throws Exception
  {}
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.common.interceptor.ApiAdminAuthorityInterceptor

 * JD-Core Version:    0.7.0.1

 */