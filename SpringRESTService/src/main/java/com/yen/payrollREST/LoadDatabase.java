package com.yen.payrollREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log =
            LoggerFactory.getLogger(LoadDatabase.class);

    // Spring Boot will run ALL CommandLineRunner beans once the application context is loaded.
    // This runner will request a copy of the EmployeeRepository you just created.
    // Using it, it will create two entities and store them.
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository){

        return args -> {
            // log.info("Preloading " + repository.save(new Employee("JIM JACK", "burglar")));
            //log.info("Preloading " + repository.save(new Employee("FRIDDIE", "thief")));

            // support first, last name
            log.info("Preloading " + repository.save(new Employee("Bilbo", "Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo", "Baggins", "thief")));
            log.info("Preloading " + repository.save(new Employee("xxx", "yyy", "???")));
        };
    }
}