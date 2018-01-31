package com.zgh.dubbo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
@Controller
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

@ImportResource(value = "classpath:applicationProvider.xml")
public class ProviderApplication implements EmbeddedServletContainerCustomizer{



	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		// TODO Auto-generated method stub
		container.setPort(8082);
	}
}
 