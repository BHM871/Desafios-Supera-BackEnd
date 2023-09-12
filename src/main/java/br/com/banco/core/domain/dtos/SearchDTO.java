package br.com.banco.core.domain.dtos;

import java.time.*;

public class SearchDTO {
    
    private final String name;

    private final LocalDateTime initial;

    private final LocalDateTime finals;
    
    public SearchDTO(String name, LocalDateTime initial, LocalDateTime finals) {
        this.name = name;
        this.initial = initial;
        this.finals = finals;
    }

    public SearchDTO() {
        this.name = "";
        this.initial = null;
        this.finals = null;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getInitial() {
        return initial;
    }

    public LocalDateTime getFinals() {
        return finals;
    }

}
