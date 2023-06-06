package pl.zzpj.repository.ports.command.user;

public interface EmailCommandPort {
  void sendEmailWithInfoAboutBlockingAccount(String to, String locale);
  void sendEmailWithInfoAboutActivatingAccount(String to, String locale);
  void sendEmailAboutAdminSession(String to, String locale, String ip);
  void sendEmailWithAccountConfirmationLink(String to, String locale, String token,
                                            String login);
}
