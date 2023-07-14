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
    private UUID idAccount;

    private String nameResponsible;

    @OneToMany(mappedBy = "account")
    private List<TransferModel> transfer = new ArrayList<TransferModel>();

    public UUID getIdAccount() {
        return idAccount;
    }

    public String getNameResponsible() {
        return nameResponsible;
    }

    public List<TransferModel> getTransfer() {
        return transfer;
    }

    public void setTransfer(List<TransferModel> transfer) {
        this.transfer = transfer;
    }
}
