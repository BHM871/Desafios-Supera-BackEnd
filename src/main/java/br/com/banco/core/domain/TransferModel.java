package br.com.banco.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

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

    private LocalDateTime transferDate;

    private BigDecimal tValue;

    @Enumerated(EnumType.STRING)
    private TransferType tType;

    private String operatorName;

    public TransferModel(
            Integer id, 
            LocalDateTime transferDate, 
            BigDecimal tValue, 
            TransferType tType,
            String operatorName, 
            Integer account_id
    ) {
        this.id = id;
        this.transferDate = transferDate;
        this.tValue = tValue;
        this.tType = tType;
        this.operatorName = operatorName;
        this.account_id = account_id;
    }

    public TransferModel() {
        this.id = null;
        this.transferDate = null;
        this.tValue = null;
        this.tType = null;
        this.operatorName = null;
        this.account_id = null;
    }

    @JoinColumn(foreignKey =  @ForeignKey())  
    private Integer account_id;

    public int getId() {
        return id;
    }

    public LocalDateTime getTransferDate() {
        return transferDate;
    }

    public BigDecimal getValue() {
        return tValue;
    }

    public TransferType getType() {
        return tType;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public int getAccount() {
        return account_id;
    }

    public void setTransferDate(LocalDateTime transferDate) {
        this.transferDate = transferDate;
    }

    public void setValue(BigDecimal tValue) {
        this.tValue = tValue;
    }

    public void setType(TransferType tType){
        this.tType = tType;
    }

    public void setOperatorName(String operatorName){
        this.operatorName = operatorName;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

}