package pl.zzpj.repository.utils.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderService {
  private final JavaMailSender mailSender;

  public void sendEmail(String toEmail, String subject, String body) {


    SimpleMailMessage message = new SimpleMailMessage();

    message.setTo(toEmail);
    message.setText(body);
    message.setSubject(subject);

    mailSender.send(message);
  }
}
