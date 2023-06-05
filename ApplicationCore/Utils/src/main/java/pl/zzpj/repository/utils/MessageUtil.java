package pl.zzpj.repository.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageUtil {
  static {
    Locale.setDefault(new Locale("default"));
  }

  public static String getMessage(String locale, String messageKey) {
    ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.forLanguageTag(locale));
    return bundle.getString(messageKey);
  }

  public static class MessageKey {
    public static final String EMAIL_ACCOUNT_BLOCKED_SUBJECT = "account.mail.subject.block";
    public static final String EMAIL_ACCOUNT_BLOCKED_MESSAGE = "account.mail.message.block";
    public static final String EMAIL_ACCOUNT_ACTIVATED_SUBJECT = "account.mail.subject.active";
    public static final String EMAIL_ACCOUNT_ACTIVATED_MESSAGE = "account.mail.message.active";
    public static final String EMAIL_ADMIN_LOGIN_SESSION_SUBJECT = "account.mail.admin.auth.subject";
    public static final String EMAIL_ADMIN_LOGIN_SESSION_MESSAGE = "account.mail.admin.auth.message";
    public static final String EMAIL_ACCOUNT_CONFIRMATION_SUBJECT = "account.mail.confirm.subject";
    public static final String EMAIL_ACCOUNT_CONFIRMATION_TOPIC1 = "account.mail.confirmation.topic1";
    public static final String EMAIL_ACCOUNT_CONFIRMATION_TOPIC2 = "account.mail.confirmation.topic2";
  }
}
