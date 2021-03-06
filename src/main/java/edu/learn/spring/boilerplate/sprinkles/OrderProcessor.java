package edu.learn.spring.boilerplate.sprinkles;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class OrderProcessor {
    private final List<Warehouse> warehouses;
    private final CustomerWallet customerWallet;

    public OrderProcessor(List<Warehouse> warehouses, CustomerWallet customerWallet) {
        this.warehouses = warehouses;
        this.customerWallet = customerWallet;
    }

    public void process(CustomerOrder order) {
        warehouses.stream()
                .filter(warehouse -> warehouse.isInStock(order.getItemId()))
                .findFirst()
                .ifPresent(warehouse -> {
                    customerWallet.chargeCustomer(order.getCustomerId(), order.getItemId());
                    warehouse.dispatchOrder(order.getCustomerId(), order.getItemId());
                });
    }
}