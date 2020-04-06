package edu.learn.spring.dependencyinjection.sprinkles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        AmazonWebsite amazonWebsite = (AmazonWebsite) context.getBean("amazonWebsite");
        amazonWebsite.acceptOrder(new CustomerOrder(3, 1));
    }

    @Bean
    public AmazonWebsite amazonWebsite(OrderProcessor orderProcessor) {
        return new AmazonWebsite(orderProcessor);
    }

    @Bean
    public OrderProcessor orderProcessor(List<Warehouse> warehouses, CustomerWallet customerWallet) {
        return new OrderProcessor(warehouses, customerWallet);
    }

    @Bean
    public Warehouse warehouse1() {
        return new Warehouse();
    }

    @Bean
    public Warehouse warehouse2() {
        return new Warehouse();
    }

    @Bean
    public CustomerWallet customerWallet() {
        return new CustomerWallet();
    }
}