package com.sphinx.common.file.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UploadFileConfig {
	@Value("${sphinx.file.uploadFolder}")
	private String uploadFileFold;
	
	@Bean
	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory=new MultipartConfigFactory();
		factory.setLocation(uploadFileFold);
		return factory.createMultipartConfig();
	}
	
	 

}
