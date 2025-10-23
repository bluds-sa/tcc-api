package com.fatec.bluds.api.infra.exceptions;

import com.fatec.bluds.api.infra.exceptions.Usuario.UsuarioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    /*
    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<String> handleBaseException(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao processar requisição");
    }
     */

    @ExceptionHandler(UsuarioNotFoundException.class)
    private ResponseEntity<String> handleUsuarioNotFoundException(UsuarioNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
