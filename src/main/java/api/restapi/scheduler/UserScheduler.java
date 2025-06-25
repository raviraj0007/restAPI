package api.restapi.scheduler;


import api.restapi.cache.AppCache;
import api.restapi.entity.JournalEntry;
import api.restapi.entity.User;
import api.restapi.enums.Sentiment;
import api.restapi.repository.UserRepository;
import api.restapi.repository.UserRepositoryImpl;
import api.restapi.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class UserScheduler {


    @Autowired
    private AppCache appCache;
    @Autowired
    private UserRepositoryImpl userRepository;
    @Autowired
    private EmailService emailService;


//    @Scheduled(cron = "*/5 * * * * *")
    public void fetchUsersAndSendEmails() {
        System.out.println("✅ fetchUsersAndSendEmails() called");
        List<User> users = userRepository.getUserForSA();
        for (User user : users) {
            // Fetch journal entries for the user in the last 7 days
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<Sentiment> sentiments = journalEntries.stream()
                    .filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS)))
                    .map(x -> x.getSentiment())
                    .collect(Collectors.toList());

            // Count occurrences of each sentiment
            Map<Sentiment, Integer> sentimentCounts = new HashMap<>(); // Initialize a map to count occurrences of each sentiment
            for (Sentiment sentiment : sentiments) { //
                if (sentiment != null) // check for null sentiment , if null then skip
                    sentimentCounts.put(sentiment, sentimentCounts.getOrDefault(sentiment, 0) + 1);
            }

            // Find the most frequent sentiment
            Sentiment mostFrequentSentiment = null;
            int maxCount = 0;
            for (Map.Entry<Sentiment, Integer> entry : sentimentCounts.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    mostFrequentSentiment = entry.getKey();
                }
            }

            if (mostFrequentSentiment != null) {
                emailService.sendSimpleMail(user.getEmails(), "Sentiment for last 7 days", mostFrequentSentiment.toString());
            }
        }

    }



    @Scheduled(cron = "0 */5 * * * *")
    public void clearAppCache(){
        appCache.init();
    }
}







