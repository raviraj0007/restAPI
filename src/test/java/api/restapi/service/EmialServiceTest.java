package api.restapi.service;


import api.restapi.scheduler.UserScheduler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class EmialServiceTest {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserScheduler userScheduler;

    @Test
    void testUserScheduler() {
        userScheduler.fetchUsersAndSendEmails();
    }

    @Test
    void testSendMail() {
        emailService.sendSimpleMail(
                "raviraj04066@gmail.com",
                "Test Subject",
                "This is a test email sent from the EmailServiceTest class."
        );

    }

}
