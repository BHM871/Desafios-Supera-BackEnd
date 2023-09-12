package br.com.banco.core.domain;

import java.io.Serializable;

import javax.persistence.*;

/*
Para a crição do model segui e acordo com o arquivo de database disponibilizado.

Eu não relacionei as tabelas pois, quando era feito a API retornava uma cascata infinita.

conta{
    [
        transferencia{
            conta{
                [
                    transferencia{
                        conta...
                    }
                ]
            }
        }
    ]
}

Desta forma optei por salvar apenas uma referencia na TB_TRANSFER para esta

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

    public AccountModel(Integer idAccount, String nameResponsible) {
        this.idAccount = idAccount;
        this.nameResponsible = nameResponsible;
    }

    public AccountModel() {
        this.idAccount = null;
        this.nameResponsible = null;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public String getNameResponsible() {
        return nameResponsible;
    }
    
}
