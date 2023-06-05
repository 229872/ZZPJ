package pl.zzpj.repository.core.domain.exception.user;

public class UserServiceDeleteException extends Exception {

  public UserServiceDeleteException(String message) {
    super(message);
  }

  public UserServiceDeleteException(String message, Throwable cause) {
    super(message, cause);
  }
}
