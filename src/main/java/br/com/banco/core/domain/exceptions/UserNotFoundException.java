package br.com.banco.core.domain.exceptions;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(){super();}

    public UserNotFoundException(String message) {super(message);}

    public UserNotFoundException(Throwable exception){super(exception);}

    public UserNotFoundException(String message, Throwable exception){super(message, exception);}

}
