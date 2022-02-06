package com.example.demo.annotation;

import org.springframework.core.annotation.AliasFor;


/**
 * @author wengjiadong
 */
public @interface ApiVersion {
    @AliasFor("value")
    String version() default "";

    @AliasFor("version")
    String value() default "";
}
