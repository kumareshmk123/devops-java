package com.changepond.springboot.controller;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@EnableWebMvc
public class MvcWebConfig implements WebMvcConfigurer{

	@Bean
	   public LocaleResolver localeResolver() {
	      SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
	      sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
	      return sessionLocaleResolver;
	   }
	
	 @Bean
	   public LocaleChangeInterceptor localeChangeInterceptor() {
	      LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	      localeChangeInterceptor.setParamName("lang");
	      return localeChangeInterceptor;
	   }
	  @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(localeChangeInterceptor());
	   }
	  
	  @Bean
	  public ResourceBundleMessageSource messageSource() {
		  
		  ResourceBundleMessageSource msg = new ResourceBundleMessageSource();
		  
		  msg.addBasenames("i18n/messages");
		  
		  return msg;
	  }
	  
	  
}