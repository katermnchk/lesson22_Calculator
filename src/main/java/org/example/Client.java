package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your math problem: ");
        String task = scanner.next();

        String encodedTask = URLEncoder.encode(task, StandardCharsets.UTF_8);
        HttpRequest request = HttpRequest.newBuilder().uri(new
                URI("http://localhost:8080/calculator?task=" +
                    encodedTask)).GET().build();

        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
        String result = send.body();
        System.out.println(result);
    }
}