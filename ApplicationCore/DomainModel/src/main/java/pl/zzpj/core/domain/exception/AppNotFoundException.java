package pl.zzpj.core.domain.exception;

public class AppNotFoundException extends AppBaseException {

    public AppNotFoundException() {
        super();
    }

    public AppNotFoundException(String message) {
        super(message);
    }

    public AppNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppNotFoundException(Throwable cause) {
        super(cause);
    }
}
