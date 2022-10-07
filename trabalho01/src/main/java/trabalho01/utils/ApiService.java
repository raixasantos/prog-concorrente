package trabalho01.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    public ApiService() {
    }

    /**
     * @throws IOException
     * @throws InterruptedException
     */
    public String sendRequest() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://hargrimm-wikihow-v1.p.rapidapi.com/steps?count=3"))
                .header("X-RapidAPI-Key", "e281c2c24amshb3a0c2492055b71p1db055jsn0786effb0a43")
                .header("X-RapidAPI-Host", "hargrimm-wikihow-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}