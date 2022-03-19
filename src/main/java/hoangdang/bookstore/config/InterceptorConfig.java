package hoangdang.bookstore.config;

import hoangdang.bookstore.interceptor.GlobalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import hoangdang.bookstore.interceptor.GlobalInterceptor;

import javax.servlet.ServletContext;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	GlobalInterceptor globalInterceptor;

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(globalInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/rest/**", "/admin/**", "/assets/**");
	}

	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("classpath:/templates");
		templateResolver.setSuffix(".html");
		return templateResolver;
	}

	/*
	 * STEP 2 - Create SpringTemplateEngine
	 * */
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}

	/*
	 * STEP 3 - Register ThymeleafViewResolver
	 * */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		registry.viewResolver(resolver);
	}


}
