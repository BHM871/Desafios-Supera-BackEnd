package br.com.banco.core.domain.exceptions;

public class InvalidArgumentException extends RuntimeException {
    
    private static String m = "Invalid Arguments";

    public InvalidArgumentException(){super(m);}

    public InvalidArgumentException(String message){super(message);}

    public InvalidArgumentException(Throwable exception){super(exception);}

    public InvalidArgumentException(String message, Throwable exception){super(message, exception);}

}
