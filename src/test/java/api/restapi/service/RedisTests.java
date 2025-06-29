package api.restapi.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


public class RedisTests {


    private RedisTemplate redisTemplate;


    @Test
    void testRedis() {
        redisTemplate.opsForValue().set("emails", "raviraj04066@gmail.com");
        Object salary = redisTemplate.opsForValue().get("salary");
        int a = 1;
    }
}
