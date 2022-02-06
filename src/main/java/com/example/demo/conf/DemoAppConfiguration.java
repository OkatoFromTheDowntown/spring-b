package com.example.demo.conf;

import com.example.demo.handler.CustomRequestHandlerMapping;
import com.example.demo.interceptor.GeneralPurposeInterceptor;
import com.example.demo.interceptor.SinglePurposeInterceptor;
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
            ContentNegotiationManager contentNegotiationManager,
            FormattingConversionService conversionService,
            ResourceUrlProvider resourceUrlProvider) {
        return super.requestMappingHandlerMapping(contentNegotiationManager, conversionService, resourceUrlProvider);
    }
}
