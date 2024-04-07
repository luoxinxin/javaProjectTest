package com.lxx.spb2hotdev.component;

import com.lxx.spb2hotdev.bean.Dog;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Component
public class BeanTest implements BeanPostProcessor {
    int k = 0;
    int j = 0;

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (AopUtils.isAopProxy(bean)) {
            return bean;
        }
        return bean;
    }


}
