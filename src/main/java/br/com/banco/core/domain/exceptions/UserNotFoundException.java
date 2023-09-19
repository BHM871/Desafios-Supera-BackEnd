package br.com.banco.core.domain.exceptions;

public class UserNotFoundException extends RuntimeException {

    private static String m = "User Not Found";
    
    public UserNotFoundException(){super(m);}

    public UserNotFoundException(String message) {super(message);}

    public UserNotFoundException(Throwable exception){super(exception);}

    public UserNotFoundException(String message, Throwable exception){super(message, exception);}

}
