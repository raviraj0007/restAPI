package api.restapi.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendSimpleMail(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            message.setFrom("fake097208@gmail.com");
            javaMailSender.send(message);
        }catch (Exception e) {
            log.error("Error sending email: {}", e.getMessage());
        }
    }
}

