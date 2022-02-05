package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author okato
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LoggingAccessFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(LoggingAccessFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        LOG.info("Incoming: {}", req.getRequestURI());
        // Servlet Filters are an implementation of the [Chain of responsibility] design pattern.
        // The chain.doFilter() is proceeding to the next element in the chain.
        // The last element of the chain is the target resource/servlet.
        // If you do not call it then the next filter (probably defined somewhere in your config.java or web.xml) will not be executed.
        chain.doFilter(request, response);
    }
}
