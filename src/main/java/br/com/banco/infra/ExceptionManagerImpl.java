package br.com.banco.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.banco.core.exceptions.InvalidArgumentException;
import br.com.banco.core.exceptions.UserNotFoundException;
import br.com.banco.core.usecases.exceptions.ExceptionManager;

@RestControllerAdvice
public class ExceptionManagerImpl implements ExceptionManager {
    
    @ExceptionHandler(InternalError.class)
    public ResponseEntity<String> actionHasNotBeenFinalized(InternalError exception){
        return ResponseEntity.internalServerError().body(exception.getMessage());
    }

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<String> invalidArgument(InvalidArgumentException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFound(UserNotFoundException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
