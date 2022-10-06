package com.trabalho01.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
    public void sendRequest() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://random-number2.p.rapidapi.com/?min=1&max=1000"))
            .header("X-RapidAPI-Key", "623cb9e05emsh977145c8dd3e439p18de75jsnfb32eaf9e6fa")
            .header("X-RapidAPI-Host", "random-number2.p.rapidapi.com")
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
