package edu.learn.spring.boilerplate.sprinkles;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmazonWebsite {

    private final OrderProcessor orderProcessor;

    public AmazonWebsite(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    @PostMapping("/accept-order")
    public String acceptOrder(@RequestBody CustomerOrder customerOrder) {
        orderProcessor.process(customerOrder);
        return "Order submitted successfully!";
    }
}