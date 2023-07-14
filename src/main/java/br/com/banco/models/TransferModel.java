package br.com.banco.models;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;

/*
Optei por retirar os métodos setters.
Pois este projeto não como objetivo mudar nenhum valor, apenas ler
*/

@Entity
@Table(name = "TB_TRANSFER")
public class TransferModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Date transferDate;

    private double value;

    private String type;

    private String operatorName;

    @ForeignKey(name = "account_id")
    @ManyToOne    
    private AccountModel account;

    public UUID getId() {
        return id;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public double getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public AccountModel getAccount() {
        return account;
    }

}