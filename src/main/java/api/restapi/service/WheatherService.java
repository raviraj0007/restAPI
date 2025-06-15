package api.restapi.service;


import api.restapi.api.response.WheatherResponse;
import api.restapi.cache.AppCache;
import api.restapi.constants.Placeholders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class WheatherService {

    @Value("${weather.api.key}")
    private String apiKey;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    public WheatherResponse getWeather(String city) {
        String finalAPI = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(Placeholders.CITY, city).replace(Placeholders.API_KEY, apiKey);
        ResponseEntity<WheatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WheatherResponse.class);
        WheatherResponse body = response.getBody();
        return body;
    }
}
