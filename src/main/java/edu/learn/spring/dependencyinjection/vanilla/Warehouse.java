package edu.learn.spring.dependencyinjection.vanilla;

public class Warehouse {
    public boolean isInStock(int itemId) {
        //would check the inventory for stock
        System.out.println("Checking if itemId=" + itemId + " exists in the inventory");
        return true;
    }

    public void dispatchOrder(int customerId, int itemId) {
        //would take care of sending item with id itemId to customer with id customerId and update its stock
        System.out.println("Dispatching itemId=" + itemId + " to customerId=" + customerId);
    }
}