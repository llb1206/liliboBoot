package com.FilterUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author fnl
 */
@Component
@Slf4j
@WebFilter(filterName = "test", urlPatterns = {"/*"})
public class TestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig)  {
        log.info("服务器启动的时候，web服务器创建Filter的实例对象，并调用其init方法，完成对象的初始化功能。filter对象只会创建一次，init方法也只会执行一次。");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        FiliterBean trimReqeust = new FiliterBean((HttpServletRequest) request);
        log.info("into filter............");
        log.info("into filter............");
        chain.doFilter(trimReqeust, response);
    }

    @Override
    public void destroy() {
        log.info(" 服务器关闭时，web服务器销毁Filter的实例对象............");
    }
}
