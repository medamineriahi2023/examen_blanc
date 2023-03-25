
package com.esprit.examen_blanc.handler;

import com.esprit.examen_blanc.exceptions.EmptyException;
import com.esprit.examen_blanc.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    public RestExceptionHandler() {
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ErrorDTO> handleException(EntityNotFoundException exception, WebRequest webRequest) {
        HttpStatus badRequest = HttpStatus.NOT_FOUND;
        ErrorDTO error = ErrorDTO.builder().errorCodes(exception.getErrorCodes()).httpCode(badRequest.value()).message(exception.getMessage()).errors(exception.getErrors()).build();
        return new ResponseEntity(error, badRequest);
    }

    @ExceptionHandler({EmptyException.class})
    public ResponseEntity<ErrorDTO> handleException(EmptyException exception, WebRequest webRequest) {
        HttpStatus badRequest = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDTO error = ErrorDTO.builder().errorCodes(exception.getErrorCodes()).httpCode(badRequest.value()).message(exception.getMessage()).errors(exception.getErrors()).build();
        return new ResponseEntity(error, badRequest);
    }
}