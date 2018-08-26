package com.springframework.DIDemo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.springframework.DIDemo.Controllers.ConstructorBasedInjector;
import com.springframework.DIDemo.Controllers.MyController;
import com.springframework.DIDemo.Controllers.PropertyBasedInjectionController;
import com.springframework.DIDemo.Controllers.SetterBasedInjecter;
import com.springframework.DIDemo.customBeans.FakeDataSource;
import com.springframework.DIDemo.customBeans.FakeJmsBroker;

@SpringBootApplication
@ComponentScan(basePackages= {"com.springframework"})
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
		//		MyController controller = (MyController) ctx.getBean("myController");
		//
		//		controller.hello();
		//
		//		// ConstructorBasedInjector cnt = ctx.getBean(ConstructorBasedInjector.class);
		//		ConstructorBasedInjector cnt = (ConstructorBasedInjector) ctx.getBean("constructorBasedInjector");
		//		cnt.sayHello();
		//
		//		SetterBasedInjecter cnt1 = (SetterBasedInjecter) ctx.getBean("setterBasedInjecter");
		//		cnt1.sayHello();
		//
		//		
		//		ctx.getBean(PropertyBasedInjectionController.class).sayHello();

		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);

		System.out.println(fakeDataSource.getUserName());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getDbURL());
		
		FakeJmsBroker jms = ctx.getBean(FakeJmsBroker.class);
		System.out.println(jms.getUsername());
		System.out.println(jms.getPwd());
		System.out.println(jms.getURL());
		System.out.println(jms.getDefaultProp());
		
//
//		AnnotationConfigApplicationContext context =
//				new AnnotationConfigApplicationContext();
//		ConfigurableEnvironment env = context.getEnvironment();
//		printSources(env);
//		System.out.println("---- System properties -----");
//		printMap(env.getSystemProperties());
//		System.out.println("---- System Env properties -----");
//		printMap(env.getSystemEnvironment());
//
	}

	private static void printMap(Map<?, ?> map) {
		// TODO Auto-generated method stub


		map.entrySet()
		.stream()
		.forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

	}

	private static void printSources(ConfigurableEnvironment env) {
		// TODO Auto-generated method stub
		System.out.println("---- property sources ----");
		for (PropertySource<?> propertySource : env.getPropertySources()) {
			System.out.println("name =  " + propertySource.getName() + "\nsource = " + propertySource
					.getSource().getClass()+"\n");
		}
	}
}
