package edu.learn.spring.dependencyinjection.sprinkles_improved;

import org.springframework.stereotype.Component;

@Component
public class CustomerWallet {
    public void chargeCustomer(int customerId, int itemId) {
        //would grab the card details of the customer with id customerId and charge for the price of the item
        //with id itemId
        System.out.println("Charging customerId=" + customerId + " for the price of itemId=" + itemId);
    }
}
