package com.zgh.dubbo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zgh.dubbo.api.IService;

@Controller
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ImportResource(value = "classpath:applicationConsumer.xml")
@SpringBootApplication
public class ConsumerApplication implements EmbeddedServletContainerCustomizer{

	@Autowired
	IService iService;

	@RequestMapping("/helloworld")
	@ResponseBody
	public String helloService() {
		return "hello world! Request iService Return:"+iService.hiService();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8009);
	}
}
 