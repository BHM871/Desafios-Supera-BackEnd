package br.com.banco.models;

import java.io.Serializable;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TB_ACCOUNT")
public class AccountModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idConta;

    private String nameResponsible;

    @OneToMany(mappedBy = "account")
    private List<TransferModel> transfer = new ArrayList<TransferModel>();

    public UUID getIdConta() {
        return idConta;
    }

    public void setIdConta(UUID idConta) {
        this.idConta = idConta;
    }

    public String getNameResponsible() {
        return nameResponsible;
    }
    
    public void setNameResponsible(String nameResponsible) {
        this.nameResponsible = nameResponsible;
    }

    public List<TransferModel> getTransfer() {
        return transfer;
    }

    public void setTransfer(List<TransferModel> transfer) {
        this.transfer = transfer;
    }
}
