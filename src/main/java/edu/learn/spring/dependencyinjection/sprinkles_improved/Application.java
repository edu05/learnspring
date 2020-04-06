package edu.learn.spring.dependencyinjection.sprinkles_improved;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

        AmazonWebsite amazonWebsite = (AmazonWebsite) run.getBean("amazonWebsite");
        amazonWebsite.acceptOrder(new CustomerOrder(3, 1));
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