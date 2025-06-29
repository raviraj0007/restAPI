package api.restapi.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedisService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    public <T> T get(String key, Class<T> entityClass) {
        try{
            Object o = redisTemplate.opsForValue().get(key);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(o.toString(), entityClass);
        } catch (Exception e) {
            log.error("Excewption",e);
            return null;
        }
    }

    public void set(String key, Object value , Long time) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(value);
            redisTemplate.opsForValue().set(key, json , time , TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("Exception", e);
        }
    }


}
