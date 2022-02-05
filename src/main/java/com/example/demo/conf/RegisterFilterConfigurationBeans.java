package com.example.demo.conf;

import com.example.demo.fileter.AuthorizationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @author okato
 */
@Configuration
public class RegisterFilterConfigurationBeans {
    @Bean
    FilterRegistrationBean<AuthorizationFilter> filterFilterRegistration() {
        final FilterRegistrationBean<AuthorizationFilter> filterRegistrationBean= new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new AuthorizationFilter());
        filterRegistrationBean.addUrlPatterns("/author/*");
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE + 100);
        return filterRegistrationBean;
    }
}
