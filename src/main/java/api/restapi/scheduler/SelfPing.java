package api.restapi.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SelfPing {

    private final RestTemplate restTemplate = new RestTemplate();


    @Scheduled(cron = "0 */14 * * * *")
    public void pingSelf() {
        try {
            restTemplate.getForObject("https://restapi-s6gb.onrender.com/public/health-check", String.class);
            // No logging needed
        } catch (Exception ignored) {
            // Fail silently
        }
    }
}