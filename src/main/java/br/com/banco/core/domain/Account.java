package br.com.banco.core.domain;

import java.io.Serializable;

import javax.persistence.*;

import br.com.banco.core.domain.dtos.AccountDTO;

@Entity
@Table(name = "TB_ACCOUNT")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nameResponsible;

    public Account(Integer id, String nameResponsible) {
        this.id = id;
        this.nameResponsible = nameResponsible;
    }

    public Account(AccountDTO data) {
        this.nameResponsible = data.getNameResponsible();
    }

    public Account() {
        this.id = null;
        this.nameResponsible = null;
    }

    public Integer getId() {
        return id;
    }

    public String getNameResponsible() {
        return nameResponsible;
    }
    
}