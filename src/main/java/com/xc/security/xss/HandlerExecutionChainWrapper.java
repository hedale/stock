package com.xc.security.xss;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.springframework.util.ReflectionUtils.FieldFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.util.HtmlUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class HandlerExecutionChainWrapper
        extends HandlerExecutionChain {
    private BeanFactory beanFactory;
    private HttpServletRequest request;
    private HandlerMethod handlerWrapper;
    private byte[] lock = new byte[0];

    public HandlerExecutionChainWrapper(HandlerExecutionChain chain, HttpServletRequest request, BeanFactory beanFactory) {
        super(chain.getHandler(), chain.getInterceptors());
        this.request = request;
        this.beanFactory = beanFactory;
    }

    public Object getHandler() {
        if (this.handlerWrapper != null) {
            return this.handlerWrapper;
        }
        synchronized (this.lock) {
            if (this.handlerWrapper != null) {
                return this.handlerWrapper;
            }
            HandlerMethod superMethodHandler = (HandlerMethod) super.getHandler();
            Object proxyBean = createProxyBean(superMethodHandler);
            this.handlerWrapper = new HandlerMethod(proxyBean, superMethodHandler.getMethod());
            return this.handlerWrapper;
        }
    }

    private Object createProxyBean(HandlerMethod handler) {
        try {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(handler.getBeanType());
            Object bean = handler.getBean();
            if ((bean instanceof String)) {
                bean = this.beanFactory.getBean((String) bean);
            }
            ControllerXssInterceptor xss = new ControllerXssInterceptor(bean);
            xss.setRequest(this.request);
            enhancer.setCallback(xss);
            return enhancer.create();
        } catch (Exception e) {
            throw new IllegalStateException("" + e.getMessage(), e);
        }
    }

    public static class ControllerXssInterceptor
            implements MethodInterceptor {
        private Object target;
        private HttpServletRequest request;
        private List<String> objectMatchPackages;

        public ControllerXssInterceptor(Object target) {
            this.target = target;
            this.objectMatchPackages = new ArrayList();
            this.objectMatchPackages.add("com.xx");
        }

        public void setRequest(HttpServletRequest request) {
            this.request = request;
        }

        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
                throws Throwable {
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    if (args[i] != null) {
                        if ((args[i] instanceof String)) {
                            args[i] = stringXssReplace((String) args[i]);
                        } else {
                            for (String pk : this.objectMatchPackages) {
                                if (args[i].getClass().getName().startsWith(pk)) {
                                    objectXssReplace(args[i]);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return method.invoke(this.target, args);
        }

        private String stringXssReplace(String argument) {
            return HtmlUtils.htmlEscape(argument);
        }

        private void objectXssReplace(final Object argument) {
            if (argument == null) {
                return;
            }
            ReflectionUtils.doWithFields(argument.getClass(), new FieldCallback() {


                public void doWith(Field field)
                        throws IllegalArgumentException, IllegalAccessException {
                    ReflectionUtils.makeAccessible(field);
                    String fv = (String) field.get(argument);
                    if (fv != null) {
                        String nv = HtmlUtils.htmlEscape(fv);
                        field.set(argument, nv);
                    }
                }
            }, new FieldFilter() {
                public boolean matches(Field field) {
                    boolean typeMatch = String.class.equals(field.getType());
                    if ((ControllerXssInterceptor.this.request != null) && ("GET".equals(ControllerXssInterceptor.this.request.getMethod()))) {
                        boolean requMatch = ControllerXssInterceptor.this.request.getParameterMap().containsKey(field.getName());
                        return (typeMatch) && (requMatch);
                    }
                    return typeMatch;
                }
            });
        }
    }
}



/* Location:           D:\BaiduNetdiskDownload\23\23\webapps\ROOT\WEB-INF\classes\

 * Qualified Name:     com.xc.security.xss.HandlerExecutionChainWrapper

 * JD-Core Version:    0.7.0.1

 */