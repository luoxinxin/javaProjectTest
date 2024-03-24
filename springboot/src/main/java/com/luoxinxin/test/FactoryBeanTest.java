package com.luoxinxin.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class FactoryBeanTest implements FactoryBean, BeanNameAware, BeanFactoryAware, BeanPostProcessor, DisposableBean {


    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setBeanName(String s) {

    }

    @Override
    public void destroy() throws Exception {

    }
}
