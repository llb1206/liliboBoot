package com.Interceptor;

import java.lang.annotation.*;
/**
 * @author liliBo
 * @date 2020/5/22 10:58
 * @Description
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequiredPermission {
    String value();
}