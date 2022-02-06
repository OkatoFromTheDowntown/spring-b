package com.example.demo.handler;

import com.example.demo.annotation.ApiVersion;
import com.example.demo.condition.CustomRequestCondition;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @author wengjiadong
 */
public class CustomRequestHandlerMapping extends RequestMappingHandlerMapping {
    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        return buildRequestConditionFrom(AnnotationUtils.findAnnotation(handlerType, ApiVersion.class));
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        return buildRequestConditionFrom(AnnotationUtils.findAnnotation(method, ApiVersion.class));
    }

    private CustomRequestCondition buildRequestConditionFrom(ApiVersion version) {
        return version == null ? null : new CustomRequestCondition(version.version());
    }
}
