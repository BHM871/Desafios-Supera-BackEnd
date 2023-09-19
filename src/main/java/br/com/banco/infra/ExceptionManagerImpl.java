package br.com.banco.infra;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.banco.core.domain.exceptions.ExceptionBody;
import br.com.banco.core.domain.exceptions.InvalidArgumentException;
import br.com.banco.core.domain.exceptions.UserNotFoundException;
import br.com.banco.core.usecases.exceptions.ExceptionManager;

@RestControllerAdvice
public class ExceptionManagerImpl implements ExceptionManager {
    
    @ExceptionHandler(InternalError.class)
    public ResponseEntity<ExceptionBody> actionHasNotBeenFinalized(InternalError exception){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status).body(newExceptionBody(exception, status.value()));
    }

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<ExceptionBody> invalidArgument(InvalidArgumentException exception){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        return ResponseEntity.status(status).body(newExceptionBody(exception, status.value()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionBody> userNotFound(UserNotFoundException exception){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.badRequest().body(newExceptionBody(exception, status.value()));
    }

    private ExceptionBody newExceptionBody(Throwable e, int status){
        
        ExceptionBody newException = new ExceptionBody();
        newException.setTimestamp(LocalDateTime.now());
        newException.setStatus(status);
        newException.setError(e.toString());
        newException.setMessage(e.getMessage());

        return newException;
    }

}
