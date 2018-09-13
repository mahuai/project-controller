package com.pro.manager.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ms
 * @Description: 跳过登录
 * @Package com.pro.manager.annotation
 * @date: Created in 2018/9/5  18:24
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SkipLogin {

    boolean flag() default true;
}
