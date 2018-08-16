package com.springframework.DIDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.ComponentScan;

import com.springframework.DIDemo.Controllers.ConstructorBasedInjector;
import com.springframework.DIDemo.Controllers.MyController;
import com.springframework.DIDemo.Controllers.PropertyBasedInjectionController;
import com.springframework.DIDemo.Controllers.SetterBasedInjecter;

@SpringBootApplication
@ComponentScan(basePackages= {"com.springframework"})
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
		MyController controller = (MyController) ctx.getBean("myController");

		controller.hello();

		// ConstructorBasedInjector cnt = ctx.getBean(ConstructorBasedInjector.class);
		ConstructorBasedInjector cnt = (ConstructorBasedInjector) ctx.getBean("constructorBasedInjector");
		cnt.sayHello();

		SetterBasedInjecter cnt1 = (SetterBasedInjecter) ctx.getBean("setterBasedInjecter");
		cnt1.sayHello();

		
		ctx.getBean(PropertyBasedInjectionController.class).sayHello();
		
		
	}

}
