package com.example.demo.anno;

import com.example.demo.type.PlatformType;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author okato
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface SupportedPlatform {
    @AliasFor("type")
    PlatformType[] value() default PlatformType.DEFAULT;

    @AliasFor("value")
    PlatformType[] type() default PlatformType.DEFAULT;
}
