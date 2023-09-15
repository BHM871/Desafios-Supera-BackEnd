package br.com.banco.core.usecases.exceptions;

import org.springframework.http.ResponseEntity;

import br.com.banco.core.exceptions.InvalidArgumentException;
import br.com.banco.core.exceptions.UserNotFoundException;

public interface ExceptionManager {
    
    public ResponseEntity<String> actionHasNotBeenFinalized(InternalError exception);

    public ResponseEntity<String> invalidArgument(InvalidArgumentException exception);

    public ResponseEntity<String> userNotFound(UserNotFoundException exception);

}
