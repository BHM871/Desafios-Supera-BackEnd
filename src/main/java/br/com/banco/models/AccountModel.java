package br.com.banco.models;

import java.io.Serializable;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/*
Optei por retirar os métodos setters.
Pois este projeto não como objetivo mudar nenhum valor, apenas ler
*/

@Entity
@Table(name = "TB_ACCOUNT")
public class AccountModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAccount;

    private String nameResponsible;


    public int getIdAccount() {
        return idAccount;
    }

    public String getNameResponsible() {
        return nameResponsible;
    }
}
