package br.com.banco.core.domain.exceptions;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionBody {
    
    private LocalDateTime timestamp;
    
    private int status;
    
    private String error;

    private String message;

}
