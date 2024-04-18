package com.xc.security.xss;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExecutionChain;


public class DispatcherServletWrapper
  extends DispatcherServlet
{
  protected HandlerExecutionChain getHandler(HttpServletRequest request)
    throws Exception
  {
    HandlerExecutionChain chain = super.getHandler(request);
    Object handler = chain.getHandler();
    if (!(handler instanceof HandlerMethod)) {
      return chain;
    }
    HandlerMethod hm = (HandlerMethod)handler;
    if (!hm.getBeanType().isAnnotationPresent(Controller.class)) {
      return chain;
    }
    return new HandlerExecutionChainWrapper(chain, request, getWebApplicationContext());
  }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.security.xss.DispatcherServletWrapper

 * JD-Core Version:    0.7.0.1

 */