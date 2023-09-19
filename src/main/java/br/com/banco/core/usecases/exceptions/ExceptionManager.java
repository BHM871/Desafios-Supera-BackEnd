package br.com.banco.core.usecases.exceptions;

import org.springframework.http.ResponseEntity;

import br.com.banco.core.domain.exceptions.ExceptionBody;
import br.com.banco.core.domain.exceptions.InvalidArgumentException;
import br.com.banco.core.domain.exceptions.UserNotFoundException;

public interface ExceptionManager {
    
    public ResponseEntity<ExceptionBody> actionHasNotBeenFinalized(InternalError exception);

    public ResponseEntity<ExceptionBody> invalidArgument(InvalidArgumentException exception);

    public ResponseEntity<ExceptionBody> userNotFound(UserNotFoundException exception);

}
