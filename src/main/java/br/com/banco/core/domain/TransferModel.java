package br.com.banco.core.domain;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;

/*
Para a crição do model segui e acordo com o arquivo de database disponibilizado.

Eu não relacionei as tabelas pois, quando era feito a API retornava uma cascata infinita.

transferencia{
    conta{
        [
            transferencia{
                conta{
                    [
                        transferencia...
                    ]
                }
            }
        ]
    }
}

Desta forma optei por salvar apenas uma referencia para a tabela de conta

Optei por retirar os métodos setters.
Pois este projeto não como objetivo mudar nenhum valor, apenas ler
*/

@Entity
@Table(name = "TB_TRANSFER")
public class TransferModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date transferDate;

    private double tValue;

    private String tType;

    private String operatorName;

    @ForeignKey(name = "account_id")    
    private Integer account_id;

    public int getId() {
        return id;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public double getValue() {
        return tValue;
    }

    public String getType() {
        return tType;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public int getAccount() {
        return account_id;
    }

}