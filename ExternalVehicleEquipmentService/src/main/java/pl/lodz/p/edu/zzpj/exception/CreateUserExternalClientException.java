package pl.lodz.p.edu.zzpj.exception;

public class CreateUserExternalClientException extends RuntimeException {
    public CreateUserExternalClientException() {
    }

    public CreateUserExternalClientException(String message) {
        super(message);
    }

    public CreateUserExternalClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateUserExternalClientException(Throwable cause) {
        super(cause);
    }
}
