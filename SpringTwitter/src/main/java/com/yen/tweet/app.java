package com.yen.tweet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


// either add to ComponentScan or update config, so java spring can scan the needed class, controller ....
// https://stackoverflow.com/questions/40384056/consider-defining-a-bean-of-type-package-in-your-configuration-spring-boot
@SpringBootApplication
@ComponentScan({"com.yen.tweet.service", "com.yen.tweet.controller", "com.yen.tweet.controllerBackup", "com.yen.tweet.search", "com.yen.tweet.api", "com.yen.tweet.user"}) // modify the spring component scan area : https://stackoverflow.com/questions/40384056/consider-defining-a-bean-of-type-package-in-your-configuration-spring-boot
public class app{

    public static void main(String[] args) {
        SpringApplication.run(app.class, args);
    }
}