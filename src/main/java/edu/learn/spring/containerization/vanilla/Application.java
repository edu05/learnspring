package edu.learn.spring.containerization.vanilla;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.setExecutor(null); // creates a default executor
        server.start();

        Warehouse warehouse1 = new Warehouse();
        Warehouse warehouse2 = new Warehouse();

        List<Warehouse> warehouses = new ArrayList<>();
        warehouses.add(warehouse1);
        warehouses.add(warehouse2);

        CustomerWallet customerWallet = new CustomerWallet();
        OrderProcessor orderProcessor = new OrderProcessor(warehouses, customerWallet);
        AmazonWebsite amazonWebsite = new AmazonWebsite(orderProcessor);
        amazonWebsite.acceptOrder(new CustomerOrder(3, 1));
    }
}