package edu.learn.spring.dependencyinjection.vanilla;

public class AmazonWebsite {

    private final OrderProcessor orderProcessor;

    public AmazonWebsite(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    public void acceptOrder(CustomerOrder customerOrder) {
        orderProcessor.process(customerOrder);
    }
}
