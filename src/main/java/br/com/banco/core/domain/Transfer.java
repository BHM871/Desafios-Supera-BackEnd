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
public class Transfer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime transferDate;

    private BigDecimal tValue;

    @Enumerated(EnumType.STRING)
    private TransferType tType;

    private String operatorName;

    @ManyToOne()
    @JoinColumn(name = "account_id")  
    private Account account;

    public Transfer(
            Long id, 
            LocalDateTime transferDate, 
            BigDecimal tValue, 
            TransferType tType,
            String operatorName, 
            Account account
    
    ) {
        this.id = id;
        this.transferDate = transferDate;
        this.tValue = tValue;
        this.tType = tType;
        this.operatorName = operatorName;
        this.account
 = account
;
    }

    public Transfer() {
        this.id = null;
        this.transferDate = null;
        this.tValue = null;
        this.tType = null;
        this.operatorName = null;
        this.account
 = null;
    }

    public Long getId() {
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

    public Account getAccount() {
        return account
;
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

    public void setAccount(Account account) {
        this.account = account;
    }

}