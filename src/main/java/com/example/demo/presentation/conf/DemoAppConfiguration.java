package com.example.demo.presentation.conf;

import com.example.demo.presentation.handler.CustomRequestHandlerMapping;
import com.example.demo.presentation.interceptor.GeneralPurposeInterceptor;
import com.example.demo.presentation.interceptor.SinglePurposeInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

/**
 * @author okato TODO class
 */
@Configuration
public class DemoAppConfiguration extends WebMvcConfigurationSupport {

    /**
     * Platform Checking Interceptor Register
     * Single Purpose Logging Interceptor Register
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GeneralPurposeInterceptor()).order(1);
        registry.addInterceptor(new SinglePurposeInterceptor()).order(2).addPathPatterns("/author/**");
    }

    @Override
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        return new CustomRequestHandlerMapping();
    }

    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping(
            @Qualifier("mvcContentNegotiationManager") ContentNegotiationManager contentNegotiationManager,
            @Qualifier("mvcConversionService") FormattingConversionService conversionService,
            @Qualifier("mvcResourceUrlProvider") ResourceUrlProvider resourceUrlProvider) {
        return super.requestMappingHandlerMapping(contentNegotiationManager, conversionService, resourceUrlProvider);
    }
}
