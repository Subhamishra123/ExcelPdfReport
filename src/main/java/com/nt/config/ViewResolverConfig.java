package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@Configuration
public class ViewResolverConfig {
	@Bean
	protected BeanNameViewResolver createViewResolver()
	{
		BeanNameViewResolver resolver=new BeanNameViewResolver();
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return resolver;
	}

}
