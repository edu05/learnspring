package edu.learn.spring.boilerplate.vanilla_improved;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public abstract class Website<IN, OUT> {

    public Website(String websiteUrl, String method, Class<IN> inputType) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext(websiteUrl, (exchange -> {
            if (exchange.getRequestMethod().equals(method)) {
                throw new UnsupportedOperationException();
            }
            ObjectMapper objectMapper = new ObjectMapper();

            //deserialize payload
            IN input = objectMapper.readValue(exchange.getRequestBody(), inputType);

            //process payload
            OUT output = process(input);

            //serialize output
            String respText = objectMapper.writeValueAsString(output);
            exchange.sendResponseHeaders(200, respText.getBytes().length);
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(respText.getBytes());
            outputStream.flush();
            exchange.close();
        }));
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    protected abstract OUT process(IN input);
}
