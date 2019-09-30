package com.bushro.config;

import java.lang.annotation.*;

/**
 *注解来标识使用哪个数据库
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
