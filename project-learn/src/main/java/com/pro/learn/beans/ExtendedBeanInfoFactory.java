package com.pro.learn.beans;

import org.springframework.beans.BeanInfoFactory;
import org.springframework.core.annotation.Order;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.learn.beans
 * @date: Created in 2018/9/11  13:59
 */
public class ExtendedBeanInfoFactory implements BeanInfoFactory, Order {
    /**
     * Return the bean info for the given class, if supported.
     *
     * @param beanClass the bean class
     * @return the BeanInfo, or {@code null} if the given class is not supported
     * @throws IntrospectionException in case of exceptions
     */
    @Override
    public BeanInfo getBeanInfo(Class<?> beanClass) throws IntrospectionException {
        return (supports(beanClass) ? new ExtendedBeanInfo(Introspector.getBeanInfo(beanClass)) : null);
    }

    /**
     * Return whether the given bean class declares or inherits any non-void
     * returning bean property or indexed property setter methods.
     */
    private boolean supports(Class<?> beanClass) {
        for (Method method : beanClass.getMethods()) {
            if (ExtendedBeanInfo.isCandidateWriteMethod(method)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The order value.
     * <p>Default is {@link org.springframework.core.Ordered#LOWEST_PRECEDENCE}.
     *
     * @see org.springframework.core.Ordered#getOrder()
     */
    @Override
    public int value() {
        return Integer.MAX_VALUE;
    }


    /**
     * Returns the annotation type of this annotation.
     *
     * @return the annotation type of this annotation
     */
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
