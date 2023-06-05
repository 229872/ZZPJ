package pl.zzpj.repository.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.zzpj.repository.ports.command.user.EmailCommandPort;
import pl.zzpj.repository.utils.MessageUtil;

@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailCommandPort {
  private final JavaMailSender mailSender;
  private final String appUrl = "http://localhost:8080";

  @Override
  public void sendEmailWithInfoAboutBlockingAccount(String to, String locale) {
    sendEmail(to,
            MessageUtil.getMessage(locale, MessageUtil.MessageKey.EMAIL_ACCOUNT_BLOCKED_SUBJECT),
            MessageUtil.getMessage(locale, MessageUtil.MessageKey.EMAIL_ACCOUNT_BLOCKED_MESSAGE)
    );
  }

  @Override
  public void sendEmailWithInfoAboutActivatingAccount(String to, String locale) {
    sendEmail(to,
            MessageUtil.getMessage(locale, MessageUtil.MessageKey.EMAIL_ACCOUNT_ACTIVATED_SUBJECT),
            MessageUtil.getMessage(locale, MessageUtil.MessageKey.EMAIL_ACCOUNT_ACTIVATED_MESSAGE)
    );
  }

  @Override
  public void sendEmailAboutAdminSession(String to, String locale, String ip) {
    sendEmail(to,
            MessageUtil.getMessage(locale, MessageUtil.MessageKey.EMAIL_ADMIN_LOGIN_SESSION_SUBJECT),
            MessageUtil.getMessage(locale, MessageUtil.MessageKey.EMAIL_ADMIN_LOGIN_SESSION_MESSAGE)
                    + ip + "."
    );
  }

  @Override
  public void sendEmailWithAccountConfirmationLink(String to, String locale, String token, String login) {
    sendEmail(to,
            MessageUtil.getMessage(locale, MessageUtil.MessageKey.EMAIL_ACCOUNT_CONFIRMATION_SUBJECT),
            MessageUtil.getMessage(locale, MessageUtil.MessageKey.EMAIL_ACCOUNT_CONFIRMATION_TOPIC1)
                    + (" " + login + ",\n")
                    + MessageUtil.getMessage(locale, MessageUtil.MessageKey.EMAIL_ACCOUNT_CONFIRMATION_TOPIC2)
                    + ("\n" + appUrl + "/users/auth/confirm?token=" + token));
  }

  private void sendEmail(String toEmail, String subject, String body) {
    SimpleMailMessage message = new SimpleMailMessage();

    message.setTo(toEmail);
    message.setText(body);
    message.setSubject(subject);

    mailSender.send(message);
  }
}
