package pl.zzpj.core.domain.exception;

public class AppBaseException extends Exception {
    public AppBaseException() {
    }

    public AppBaseException(String message) {
        super(message);
    }

    public AppBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppBaseException(Throwable cause) {
        super(cause);
    }
}
