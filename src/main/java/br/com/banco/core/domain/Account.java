package br.com.banco.core.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import br.com.banco.core.domain.dtos.AccountDTO;

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
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nameResponsible;

    @OneToMany()
    private List<Transfer> transfers = new ArrayList<Transfer>();

    public Account(Integer id, String nameResponsible, List<Transfer> transfers) {
        this.id = id;
        this.nameResponsible = nameResponsible;
        this.transfers = transfers;
    }

    public Account(AccountDTO data) {
        this.nameResponsible = data.getNameResponsible();
        this.transfers = new ArrayList<Transfer>();
    }

    public Account() {
        this.id = null;
        this.nameResponsible = null;
        this.transfers = new ArrayList<Transfer>();
    }

    public int getId() {
        return id;
    }

    public String getNameResponsible() {
        return nameResponsible;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }
    
}
