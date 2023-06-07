package pl.zzpj.repository.rest.exceptions;

public class BadTireTypeException extends Exception {
    public BadTireTypeException() {
    }

    public BadTireTypeException(String message) {
        super(message);
    }

    public BadTireTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadTireTypeException(Throwable cause) {
        super(cause);
    }
}
