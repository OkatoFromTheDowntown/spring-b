package com.example.demo.presentation.interceptor;

import com.example.demo.presentation.annotation.SupportedPlatform;
import com.example.demo.presentation.exception.UnsupportedMediaException;
import com.example.demo.presentation.type.PlatformType;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Platform Checking Interceptor for general (before all requests' calling)
 *
 * @author okato
 */
@SupportedPlatform({PlatformType.WINDOWS, PlatformType.LINUX, PlatformType.MAC})
public class GeneralPurposeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException, UnsupportedMediaException {
        SupportedPlatform supportedPlatform = AnnotationUtils
                .findAnnotation(GeneralPurposeInterceptor.class, SupportedPlatform.class);

        if (supportedPlatform == null) {
            return true;
        }

        PlatformType[] supported = supportedPlatform.value();
        PlatformType reqPlatformType = PlatformType.descOf(request.getHeader("X-platform"));

        if (!Arrays.stream(supported).toList().contains(reqPlatformType)) {
            throw new UnsupportedMediaException("Supported media types in: " + Arrays.toString(supported));
        }

        return true;
    }
}
