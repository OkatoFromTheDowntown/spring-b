package com.example.demo.anno;

import com.example.demo.type.PlatformType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author okato
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Platform {
    PlatformType value() default PlatformType.DEFAULT;
}
