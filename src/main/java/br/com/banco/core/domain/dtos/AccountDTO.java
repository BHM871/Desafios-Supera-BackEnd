package br.com.banco.core.domain.dtos;

public class AccountDTO {

    private final String nameResponsible;

    public AccountDTO(String nameResponsible) {
        this.nameResponsible = nameResponsible;
    }

    public String getNameResponsible() {
        return nameResponsible;
    }
    
}
