package br.com.banco.core.domain.dtos;

import java.time.LocalDateTime;

public class FiltersDTO {
    
    private final String name;

    private final LocalDateTime start;

    private final LocalDateTime end;
    
    public FiltersDTO(String name, LocalDateTime start, LocalDateTime end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

}
