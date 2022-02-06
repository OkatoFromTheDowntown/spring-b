package com.example.demo.interceptor;

import com.example.demo.annotation.SupportedPlatform;
import com.example.demo.type.PlatformType;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author okato
 */
@SupportedPlatform({PlatformType.WINDOWS, PlatformType.LINUX, PlatformType.MAC})
public class GeneralPurposeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        SupportedPlatform supportedPlatform = AnnotationUtils
                .findAnnotation(GeneralPurposeInterceptor.class, SupportedPlatform.class);

        if (supportedPlatform == null) {
            return true;
        }

        PlatformType[] supported = supportedPlatform.value();
        PlatformType reqPlatformType = PlatformType.descOf(request.getHeader("X-platform"));

        if (!Arrays.stream(supported).toList().contains(reqPlatformType)) {
            response.setStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
            response.setContentType("application/json");
            response.getWriter().write("{" + "\"timestamp\":" + System.currentTimeMillis() + ","
                    + "\"status\":" + HttpStatus.UNSUPPORTED_MEDIA_TYPE.value() + ","
                    + "\"error\":\"" + HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase() + "\","
                    + "\"path\":\"" + request.getRequestURI() + "\"}");
            return false;
        }

        return true;
    }
}
