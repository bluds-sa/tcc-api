package com.fatec.bluds.api.Infra.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<String> handleBaseException(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao processar requisição");
    }
}
