package com.sphinx.common.file.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class UploadFilePathConfig implements WebMvcConfigurer  {
	@Value("${sphinx.file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${sphinx.file.uploadFolder}")
    private String uploadFolder;
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler(staticAccessPath).addResourceLocations("file:"+uploadFolder);
	}
	

   
}
