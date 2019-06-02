package com.sphinx.cxf.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import com.sphinx.cxf.service.imp.SayHelloImp;

@Configuration
public class WebServiceConfig {

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus SpringBus() {
		return new SpringBus();
	}
	
	@Bean
	public ServletRegistrationBean DispatcherServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/webservice/*");
	}
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpointImpl=new EndpointImpl(SpringBus(), new SayHelloImp());
		endpointImpl.publish("/hello");
		return endpointImpl;
	}
}
