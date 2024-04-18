package com.xc.common.filter;

import com.xc.common.ResponseCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


public class ExceptionResolver
  implements HandlerExceptionResolver
{
  private static final Logger log = LoggerFactory.getLogger(ExceptionResolver.class);
  
  public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e)
  {
    log.error("==============================ExceptionResolver=================================");
    log.error("{} Exception by xiongcan", httpServletRequest.getRequestURI(), e);
    
    ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
    modelAndView.addObject("status", Integer.valueOf(ResponseCode.ERROR.getCode()));
    modelAndView.addObject("msg", "自定义接口异常，详情请查看日志");
    modelAndView.addObject("data", e.toString());
    
    return modelAndView;
  }

}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.common.filter.ExceptionResolver

 * JD-Core Version:    0.7.0.1

 */