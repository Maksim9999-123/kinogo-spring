package com.itspace.kinogospringrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.itspace.kinogospringcommon.*", "com.itspace.kinogospringrest.*"})
@EnableJpaRepositories(basePackages = {"com.itspace.kinogospringcommon.repository"})
@EntityScan({"com.itspace.kinogospringcommon.model.entity"})
@SpringBootApplication
public class KinogoSpringRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(KinogoSpringRestApplication.class, args);
    }

}
