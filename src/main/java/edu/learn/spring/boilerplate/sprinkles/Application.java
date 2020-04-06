package edu.learn.spring.boilerplate.sprinkles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Warehouse warehouse1() {
        return new Warehouse();
    }

    @Bean
    public Warehouse warehouse2() {
        return new Warehouse();
    }
}