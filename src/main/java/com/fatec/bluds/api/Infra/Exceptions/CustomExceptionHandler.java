package com.fatec.bluds.api.infra.exceptions;

import com.fatec.bluds.api.infra.exceptions.Usuario.UsuarioNotFoundException;
import com.fatec.bluds.api.infra.exceptions.dto.ApiErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * Trata exceções genéricas de Runtime (fallback)
     */
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ApiErrorDTO> handleBaseException(RuntimeException exception, HttpServletRequest request) {
//        var dto = new ApiErrorDTO(
//                HttpStatus.BAD_REQUEST.value(),
//                "Erro ao processar requisição",
//                exception.getMessage(),
//                request.getRequestURI(),
//                Instant.now()
//        );
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
//    }

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<String> handleBaseException(RuntimeException exception) {
        exception.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    /**
     * Trata quando o usuário não é encontrado
     */
    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<ApiErrorDTO> handleUsuarioNotFound(
            UsuarioNotFoundException exception,
            HttpServletRequest request) {

        var dto = new ApiErrorDTO(
                HttpStatus.NOT_FOUND.value(),
                "Usuário não encontrado",
                exception.getMessage(),
                request.getRequestURI(),
                Instant.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }
}
