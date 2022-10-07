package trabalho01.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Body {

    @JsonProperty("1")
    private String phrase;

    
    /** 
     * @return String A phrase received from response.
     */
    public String getPhrase() {
        return phrase;
    }

    
    /** 
     * Phrase is a represention of a field in WikiHow API's json.
     * @param phrase
     */
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    
    /** 
     * Treat a response received from some request.
     * @param response
     * @return Body
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    public Body treatResponse(String response) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Body body = mapper.readValue(response, Body.class);
        return body;
    }
}
