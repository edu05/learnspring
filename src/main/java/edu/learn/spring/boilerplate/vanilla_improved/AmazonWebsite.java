package edu.learn.spring.boilerplate.vanilla_improved;

import java.io.IOException;

public class AmazonWebsite extends Website<CustomerOrder, String> {

    private final OrderProcessor orderProcessor;

    public AmazonWebsite(OrderProcessor orderProcessor) throws IOException {
        super("/accept-order", "POST", CustomerOrder.class);
        this.orderProcessor = orderProcessor;
    }

    @Override
    protected String process(CustomerOrder input) {
        acceptOrder(input);
        return "Order submitted successfully!";
    }

    public void acceptOrder(CustomerOrder customerOrder) {
        orderProcessor.process(customerOrder);
    }
}
