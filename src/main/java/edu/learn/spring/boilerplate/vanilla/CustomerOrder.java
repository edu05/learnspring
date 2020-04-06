package edu.learn.spring.boilerplate.vanilla;

public class CustomerOrder {
    private int itemId;
    private int customerId;

    private CustomerOrder() {
        //for deserialization
    }

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
