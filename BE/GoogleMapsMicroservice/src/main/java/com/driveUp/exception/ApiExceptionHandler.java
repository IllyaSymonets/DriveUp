package com.driveUp.exception;

import org.springframework.aop.AopInvocationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiException.class,
            DateTimeParseException.class,
            NullPointerException.class,
            ConstraintViolationException.class,
            AopInvocationException.class,
            NumberFormatException.class})
    public ResponseEntity<Object> handleApiException(ApiException e) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiExceptionBody apiExceptionBody = new ApiExceptionBody(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiExceptionBody, badRequest);
    }

}
