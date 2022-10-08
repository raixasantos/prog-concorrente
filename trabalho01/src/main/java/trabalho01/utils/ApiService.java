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
     * Set and send a request to the WikiHow API.
     * 
     * @return String Response received from a request.
     * @throws IOException
     * @throws InterruptedException
     */
    public String sendRequest() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://hargrimm-wikihow-v1.p.rapidapi.com/images?count=3"))
                .header("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
                .header("X-RapidAPI-Host", "hargrimm-wikihow-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}