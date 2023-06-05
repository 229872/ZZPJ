package pl.zzpj.repository.rest.exception;

public class UserCreationException extends Exception {
  public UserCreationException(String message, Throwable cause) {
    super(message, cause);
  }

  public UserCreationException(String message) {
    super(message);
  }
}
