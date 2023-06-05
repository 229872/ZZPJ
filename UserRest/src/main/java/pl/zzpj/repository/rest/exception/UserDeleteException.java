package pl.zzpj.repository.rest.exception;

public class UserDeleteException extends Exception {
  public UserDeleteException(String message) {
    super(message);
  }

  public UserDeleteException(String message, Throwable cause) {
    super(message, cause);
  }
}
