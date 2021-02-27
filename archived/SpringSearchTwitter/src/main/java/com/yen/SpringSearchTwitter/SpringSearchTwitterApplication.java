package com.yen.SpringSearchTwitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.social.config.annotation.EnableSocial;

@EnableSocial
@SpringBootApplication
public class SpringSearchTwitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSearchTwitterApplication.class, args);
	}

}
