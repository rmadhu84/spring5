package com.springframework.DIDemo.BeanProcessors;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.springframework.DIDemo.ServiceImpl.PrimaryGreetingServiceImpl;

@Component
public class CustomBeanProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		if(bean instanceof PrimaryGreetingServiceImpl) {
			((PrimaryGreetingServiceImpl)bean).beforeInit();
		}
		return bean;
	}
	
	@Override
	public Object  postProcessAfterInitialization(Object bean, String beanName) {
		if(bean instanceof PrimaryGreetingServiceImpl) {
			((PrimaryGreetingServiceImpl)bean).afterInit();
		}
		return bean;
	}
	
}
