
package br.com.banco.core.domain.dtos;

import java.math.BigDecimal;

import br.com.banco.core.domain.TransferType;

public class TransferDTO {

    private final BigDecimal tValue;

    private final TransferType tType;

    private final String operatorName;

    private Integer accountId;

    public TransferDTO(
        BigDecimal tValue,
        TransferType tType,
        String operatorName,
        Integer accountId
    ){
        this.tValue = tValue;
        this.tType = tType;
        this.operatorName = operatorName;
        this.accountId = accountId;
    }

    public TransferDTO(){
        this.tValue = null;
        this.tType = null;
        this.operatorName = null;
        this.accountId = null;
    }

    public BigDecimal gettValue() {
        return tValue;
    }

    public TransferType gettType() {
        return tType;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public Integer getAccountId() {
        return accountId;
    }
    
}