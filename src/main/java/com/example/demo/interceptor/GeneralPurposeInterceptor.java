package com.example.demo.interceptor;

import com.example.demo.anno.SupportedPlatform;
import com.example.demo.type.PlatformType;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author okato
 */
@SupportedPlatform({PlatformType.WINDOWS, PlatformType.LINUX, PlatformType.MAC})
public class GeneralPurposeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        PlatformType[] supported = Objects.requireNonNull(AnnotationUtils.findAnnotation(GeneralPurposeInterceptor.class, SupportedPlatform.class)).value();
        PlatformType reqPlatformType = PlatformType.descOf(request.getHeader("x-platform"));
        if (!Arrays.stream(supported).toList().contains(reqPlatformType)) {
            response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
            response.setContentType("application/json");
            response.getWriter().write("{" + "\"timestamp\":" + System.currentTimeMillis() + ","
                    + "\"status\":" + HttpStatus.NOT_ACCEPTABLE.value() + ","
                    + "\"error\":\"" + HttpStatus.NOT_ACCEPTABLE.getReasonPhrase() + "\","
                    + "\"path\":\"" + request.getRequestURI() + "\"}");
            return false;
        }
        return true;
    }
}
