package br.com.banco.core.domain.dtos;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@AllArgsConstructor
public class FiltersDTO {
    
    private final String name;
    private final LocalDateTime start;
    private final LocalDateTime end;
    
}