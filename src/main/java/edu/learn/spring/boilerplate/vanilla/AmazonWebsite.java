package edu.learn.spring.boilerplate.vanilla;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class AmazonWebsite {

    private final OrderProcessor orderProcessor;

    public AmazonWebsite(OrderProcessor orderProcessor) throws IOException {
        this.orderProcessor = orderProcessor;
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/accept-order", (exchange -> {
            if (exchange.getRequestMethod().equals("POST")) {
                throw new UnsupportedOperationException();
            }

            CustomerOrder customerOrder = new ObjectMapper().readValue(exchange.getRequestBody(), CustomerOrder.class);
            acceptOrder(customerOrder);

            String respText = "Order submitted successfully!";
            exchange.sendResponseHeaders(200, respText.getBytes().length);
            OutputStream output = exchange.getResponseBody();
            output.write(respText.getBytes());
            output.flush();
            exchange.close();
        }));
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    public void acceptOrder(CustomerOrder customerOrder) {
        orderProcessor.process(customerOrder);
    }
}
