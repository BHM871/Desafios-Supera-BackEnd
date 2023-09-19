package br.com.banco.core.domain.exceptions;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionBody {
    
    private Long timestamp;
    
    private int status;
    
    private String error;

    private String exception;

    private String message;

    private String path;

}
