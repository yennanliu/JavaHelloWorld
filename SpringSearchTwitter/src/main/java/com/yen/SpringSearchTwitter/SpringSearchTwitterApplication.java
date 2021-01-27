package com.yen.SpringSearchTwitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@EnableFeignClients
@ComponentScan("com.yen.SpringSearchTwitter.controller") //to scan controller
public class SpringSearchTwitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSearchTwitterApplication.class, args);
	}

}
