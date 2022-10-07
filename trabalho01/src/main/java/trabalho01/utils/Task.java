package trabalho01.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Task {

    public Task() {
    }

    public void run() throws JsonMappingException, JsonProcessingException, IOException, InterruptedException {
        ApiService apiService = new ApiService();
        String response = apiService.sendRequest();
        Body body = new Body();
        body = body.treatResponse(response);
        System.out.println(body.getPhrase());
    }
}
