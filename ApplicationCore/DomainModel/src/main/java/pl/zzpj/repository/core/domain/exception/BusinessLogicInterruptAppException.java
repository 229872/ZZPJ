package pl.zzpj.repository.core.domain.exception;

public class BusinessLogicInterruptAppException extends AppBadRequestException {

    public BusinessLogicInterruptAppException() {
        super();
    }

    public BusinessLogicInterruptAppException(String message) {
        super(message);
    }

    public BusinessLogicInterruptAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessLogicInterruptAppException(Throwable cause) {
        super(cause);
    }
}
