package edu.learn.spring.boilerplate.vanilla;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        Warehouse warehouse1 = new Warehouse();
        Warehouse warehouse2 = new Warehouse();

        List<Warehouse> warehouses = new ArrayList<>();
        warehouses.add(warehouse1);
        warehouses.add(warehouse2);

        CustomerWallet customerWallet = new CustomerWallet();
        OrderProcessor orderProcessor = new OrderProcessor(warehouses, customerWallet);
        AmazonWebsite amazonWebsite = new AmazonWebsite(orderProcessor);
    }
}