package com.pro.manager.annotation;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.manager.annotation
 * @date: Created in 2018/9/6  11:31
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ms
 * @Description: 权限过滤
 * @Package com.pro.manager.annotation
 * @date: Created in 2018/9/5  18:24
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorityPass {

    boolean flag() default true;
}
