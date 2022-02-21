package com.example.demo.presentation.handler;

import com.example.demo.presentation.exception.ApplicationException;
import com.example.demo.presentation.exception.UnsupportedMediaException;
import com.example.demo.presentation.exception.dto.GeneralApplicationExceptionObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author okato
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<GeneralApplicationExceptionObject> handleApplicationException(final ApplicationException e) {
        return new ResponseEntity<>(GeneralApplicationExceptionObject.builder()
                .withDescription(e.getMessage())
                .withErrType(ApplicationException.class.getSimpleName())
                .withStatus(HttpStatus.NOT_FOUND.value())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnsupportedMediaException.class)
    public ResponseEntity<GeneralApplicationExceptionObject> handleUnsupportedMediaException(final UnsupportedMediaException e) {
        return new ResponseEntity<>(GeneralApplicationExceptionObject.builder()
                .withTitle("Unsupported media type")
                .withErrCode("Error Code: 415")
                .withErrType(UnsupportedMediaException.class.getSimpleName())
                .withDescription(e.getMessage())
                .withStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
                .build(), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<GeneralApplicationExceptionObject> handleException(final Throwable e) {
        return new ResponseEntity<>(GeneralApplicationExceptionObject.builder()
                .withTitle("System Error")
                .withDescription(e.getMessage())
                .withErrType(Throwable.class.getSimpleName())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
