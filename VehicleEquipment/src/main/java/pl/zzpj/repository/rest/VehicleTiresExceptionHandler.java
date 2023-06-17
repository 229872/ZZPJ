package pl.zzpj.repository.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import pl.zzpj.repository.rest.exceptions.BadTireTypeException;
import pl.zzpj.repository.rest.exceptions.ErrorMessage;
import pl.zzpj.repository.rest.exceptions.VehicleEquipmentRestCreateException;
import pl.zzpj.repository.rest.exceptions.VehicleEquipmentRestNotFoundException;
import pl.zzpj.repository.rest.exceptions.VehicleEquipmentRestUpdateException;

import java.util.Date;

@RestControllerAdvice(basePackageClasses = VehicleTiresRestController.class)
public class VehicleTiresExceptionHandler {

    @ExceptionHandler(VehicleEquipmentRestNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> handleEquipmentNotFound(VehicleEquipmentRestNotFoundException ex,
                                                                WebRequest request) {
        ErrorMessage message = new ErrorMessage(
            HttpStatus.NOT_FOUND.value(),
            new Date(),
            ex.getMessage(),
            request.getDescription(true));

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VehicleEquipmentRestCreateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleEquipmentCreationFailed(VehicleEquipmentRestCreateException ex,
                                                                      WebRequest request) {
        ErrorMessage message = new ErrorMessage(
            HttpStatus.BAD_REQUEST.value(),
            new Date(),
            ex.getMessage(),
            request.getDescription(false));

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VehicleEquipmentRestUpdateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleEquipmentUpdateFailed(VehicleEquipmentRestUpdateException ex,
                                                                    WebRequest request) {
        ErrorMessage message = new ErrorMessage(
            HttpStatus.BAD_REQUEST.value(),
            new Date(),
            ex.getMessage(),
            request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadTireTypeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleBadTireType(BadTireTypeException ex,
                                                          WebRequest request) {
        ErrorMessage message = new ErrorMessage(
            HttpStatus.BAD_REQUEST.value(),
            new Date(),
            ex.getMessage(),
            request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ErrorMessage> handleOtherError(Exception ex,
                                                         WebRequest request) {
        ErrorMessage message = new ErrorMessage(
            HttpStatus.OK.value(),
            new Date(),
            ex.getMessage(),
            request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.OK);
    }

}
