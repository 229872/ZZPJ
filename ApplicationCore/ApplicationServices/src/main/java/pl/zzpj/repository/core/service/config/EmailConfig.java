package pl.zzpj.repository.core.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {
  @Value("${spring.mail.host}")
  private String mailHost;
  @Value("${spring.mail.port}")
  private Integer mailPort;

  @Bean
  public JavaMailSender getJavaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost(mailHost);
    mailSender.setPort(mailPort);

    mailSender.setUsername(System.getenv("MAIL_MAIL2"));
    mailSender.setPassword(System.getenv("MAIL_PASSWORD2"));

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");

    return mailSender;
  }
}
