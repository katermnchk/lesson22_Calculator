package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GreetingHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();

        Map<String, String> parameters = getParameters(query);

        String name = parameters.get("name");
        int age = Integer.parseInt(parameters.get("age"));

        String message = "Hello %s, %s!".formatted(name, age);

        exchange.sendResponseHeaders(200, message.length());

        exchange.getResponseBody().write(message.getBytes());

        exchange.getResponseBody().close();
    }

    public Map<String, String> getParameters(String query) {
        Map<String, String> greetings = new HashMap<>();
        String[] split = query.split("&");
        for (String s : split) {
            String[] split1 = s.split("=");
            greetings.put(split1[0], split1[1]);
        }
        return greetings;
    }
}