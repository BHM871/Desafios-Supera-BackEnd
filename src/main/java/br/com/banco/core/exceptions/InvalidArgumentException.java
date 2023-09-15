package br.com.banco.core.exceptions;

public class InvalidArgumentException extends RuntimeException {
    
    public InvalidArgumentException(){super();}

    public InvalidArgumentException(String message){super(message);}

    public InvalidArgumentException(Throwable exception){super(exception);}

    public InvalidArgumentException(String message, Throwable exception){super(message, exception);}

}
