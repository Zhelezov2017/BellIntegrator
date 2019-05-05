package ru.mithril.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerOne extends ResponseEntityExceptionHandler {

    //@ExceptionHandler(ThereIsNoSuchUserException.class)
    //protected ResponseEntity<AwesomeException> handleThereIsNoSuchUserException() {
     //   return new ResponseEntity<>(new AwesomeException(), HttpStatus.NOT_FOUND);
    //}

    @Data
    @AllArgsConstructor
    private static class AwesomeException {
        private String message;
    }
}
