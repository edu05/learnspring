package edu.learn.spring.dependencyinjection.sprinkles;

public class CustomerOrder {
    private int itemId;
    private int customerId;

    public CustomerOrder(int itemId, int customerId) {
        this.itemId = itemId;
        this.customerId = customerId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getCustomerId() {
        return customerId;
    }
}