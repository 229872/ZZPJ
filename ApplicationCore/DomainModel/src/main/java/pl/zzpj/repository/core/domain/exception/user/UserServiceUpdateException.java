package pl.zzpj.repository.core.domain.exception.user;

public class UserServiceUpdateException extends Exception {
  public UserServiceUpdateException(String message) {
    super(message);
  }

  public UserServiceUpdateException(String message, Throwable cause) {
    super(message, cause);
  }
}
