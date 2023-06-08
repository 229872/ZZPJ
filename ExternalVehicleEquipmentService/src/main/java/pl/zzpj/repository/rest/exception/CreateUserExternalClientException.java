package pl.zzpj.repository.rest.exception;

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
