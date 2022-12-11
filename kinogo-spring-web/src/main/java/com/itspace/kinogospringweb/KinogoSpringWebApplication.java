package com.itspace.kinogospringweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.itspace.kinogospringcommon.*", "com.itspace.kinogospringweb.*"})
@EnableJpaRepositories(basePackages = {"com.itspace.kinogospringcommon.repository"})
@EntityScan({"com.itspace.kinogospringcommon.model.entity"})
@SpringBootApplication
public class KinogoSpringWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(KinogoSpringWebApplication.class, args);
    }

}
