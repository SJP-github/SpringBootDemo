package com.sjp.quickstart;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 1.添加@configuration注解
 * 2.实现Filter接口的Filter方法，将自定义FIlter加入过滤链
 */

@Configuration
public class WebConfiguration {

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    /**
     * 自定义过滤器MyFilter
     */
    public class MyFilter implements Filter{
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            System.out.println("This is MyFilter,url:"+request.getRequestURI());
            filterChain.doFilter(servletRequest,servletResponse);
        }

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            System.out.println("Filter init method!");
        }

        @Override
        public void destroy() {

        }
    }

    /**
     * 将自定义过滤器注册
     * @return
     */
    @Bean
    public FilterRegistrationBean addFilter() {

        FilterRegistrationBean registration=new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.setName("MyFilter");
        registration.setOrder(1);
        registration.addUrlPatterns("/*");//过滤所有请求
        registration.addInitParameter("paramname", "paramvalue");//初始化参数

        return registration;
    }
}
