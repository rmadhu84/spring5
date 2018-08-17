/**
 * 
 */
package com.springframework.DIDemo.ServiceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springframework.DIDemo.Service.GreetingService;
import com.springframework.DIDemo.repository.GreetingRepository;
import com.springframework.DIDemo.repository.GreetingRepository2;

/**
 * @author Madhu
 *
 */
//@Service
//@Primary
//@Profile({"en", "default"})
public class PrimaryGreetingServiceImpl implements GreetingService, InitializingBean, BeanNameAware,
BeanFactoryAware, ApplicationContextAware, DisposableBean {

	private static final Logger logger = LoggerFactory.getLogger(PrimaryGreetingServiceImpl.class);
	
	private GreetingRepository2 greetingRepo;
	
	
	/**
	 * @param greetingRepo
	 */
	public PrimaryGreetingServiceImpl(GreetingRepository2 greetingRepo) {
		super();
		this.greetingRepo = greetingRepo;
		logger.info("#### We are in Primary Greeting Bean. ");
	}

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
//		System.out.println("Hello - From Primary Greeting Service");
		return greetingRepo.primaryGreet();
		
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("#### The Primary bean has its properties set. ");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		logger.info("#### The Primary Bean has been Terminated. ");
	}

	@Override
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
		logger.info("#### The Primay bean's name has been set. ");
		
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub
		logger.info("### The Primary Bean's factory has been set. ");
		
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		logger.info("### The application context is set.");
	}
	
	@PostConstruct
	public void postContruct() {
		logger.info("#### The PostConstruct method has been called. The primary bean has been constructed.");
		
	}
	
	@PreDestroy
	public void preDestroy() {
		logger.info("#### The Pre-Destroy method has been called.");
	}

	public void beforeInit() {
		logger.info("#### Before init - Called by the Bean Post Processor");
	}
	public void afterInit() {
		logger.info("#### After init - Called by the Bean Post Processor");
	}
}
