package pl.zzpj.repository.core.domain.exception.user;

public class UserServiceNotFoundException extends Exception {
  public UserServiceNotFoundException(String message) {
    super(message);
  }

  public UserServiceNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
