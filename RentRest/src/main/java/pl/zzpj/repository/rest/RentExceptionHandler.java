package pl.zzpj.repository.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import pl.zzpj.repository.core.domain.exception.rent.*;
import pl.zzpj.repository.core.domain.exception.user.UserServiceNotFoundException;
import pl.zzpj.repository.rest.controller.RentController;
import pl.zzpj.repository.rest.dto.ErrorMessage;

import java.util.Date;

@RestControllerAdvice(basePackageClasses = RentController.class)
public class RentExceptionHandler {

    @ExceptionHandler(RentCannotIssueVehicleException.class)
    public ResponseEntity<ErrorMessage> handleRentCannotIssueVehicle(RentCannotIssueVehicleException ex,
                                                                     WebRequest request) {
        ErrorMessage message = new ErrorMessage(ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RentInvalidDatePeriodException.class)
    public ResponseEntity<ErrorMessage> handleRentInvalidDatePeriod(RentInvalidDatePeriodException ex,
                                                                    WebRequest request) {
        ErrorMessage message = new ErrorMessage(ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RentNotCancellableException.class)
    public ResponseEntity<ErrorMessage> handleRentNotCancellable(RentNotCancellableException ex,
                                                                 WebRequest request) {
        ErrorMessage message = new ErrorMessage(ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RentNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleRentNotFound(RentNotFoundException ex,
                                                           WebRequest request) {
        ErrorMessage message = new ErrorMessage(ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RentVehicleNotIssuedException.class)
    public ResponseEntity<ErrorMessage> handleRentVehicleNotIssued(RentVehicleNotIssuedException ex,
                                                                   WebRequest request) {
        ErrorMessage message = new ErrorMessage(ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserServiceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleRentVehicleNotIssued(UserServiceNotFoundException ex,
                                                                   WebRequest request) {
        ErrorMessage message = new ErrorMessage(ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorMessage> handleRentVehicleNotIssued(MethodArgumentTypeMismatchException ex,
                                                                   WebRequest request) {
        ErrorMessage message = new ErrorMessage(ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
