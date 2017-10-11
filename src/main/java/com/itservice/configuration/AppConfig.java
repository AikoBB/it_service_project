package com.itservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.itservice")
public class AppConfig {

	@Bean
	public ViewResolver viewSolver(){
		InternalResourceViewResolver viewSolver = new InternalResourceViewResolver();
		viewSolver.setViewClass(JstlView.class);
		viewSolver.setPrefix("/WEB-INF/view/");
		viewSolver.setSuffix(".jsp");
		return viewSolver;
	}

}
