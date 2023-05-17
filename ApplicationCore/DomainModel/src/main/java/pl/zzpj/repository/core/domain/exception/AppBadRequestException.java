package pl.zzpj.repository.core.domain.exception;

public class AppBadRequestException extends AppBaseException {

    public AppBadRequestException() {
        super();
    }

    public AppBadRequestException(String message) {
        super(message);
    }

    public AppBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppBadRequestException(Throwable cause) {
        super(cause);
    }
}
