package pl.zzpj.repository.core.domain.exception.user.auth;

public class AuthenticationException extends Exception {
  public AuthenticationException(String message) {
    super(message);
  }

  public AuthenticationException(String message, Throwable cause) {
    super(message, cause);
  }
}
