package com.example.demo.application.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author okato
 */
public class SinglePurposeInterceptor implements HandlerInterceptor {

    private final Logger LOG = LoggerFactory.getLogger(SinglePurposeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("This a Single purpose log message from Interceptor:preHandle");
        return true;
    }
}
