package br.com.banco.core.domain.dtos;

public class AccountDTO {

    private final Integer id;
    private final String nameResponsible;

    public AccountDTO(Integer id, String nameResponsible) {
        this.id = id;
        this.nameResponsible = nameResponsible;
    }

    public Integer getId() {
        return id;
    }

    public String getNameResponsible() {
        return nameResponsible;
    }
    
}
