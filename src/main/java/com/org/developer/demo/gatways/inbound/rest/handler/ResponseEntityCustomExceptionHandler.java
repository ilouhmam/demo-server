package com.org.developer.demo.gatways.inbound.rest.handler;

import com.org.developer.demo.core.domain.technical.error.ErrorResponse;
import com.org.developer.demo.core.domain.technical.exception.DemoException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class ResponseEntityCustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = DemoException.class)
    protected ResponseEntity<Object> handleAccountException(
            RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ErrorResponse(ex.getMessage()),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Optional<FieldError> optionalFieldError = Optional.ofNullable(ex.getBindingResult().getFieldError());
        return handleExceptionInternal(ex, new ErrorResponse(optionalFieldError.isPresent()?(optionalFieldError.get().getField() + " " + optionalFieldError.get().getDefaultMessage()):"Une Erreur est survenue"),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
