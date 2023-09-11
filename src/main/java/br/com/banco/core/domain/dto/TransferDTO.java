package br.com.banco.core.domain.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TransferDTO {

    private final BigDecimal tValue;

    private final String tType;

    private final String operatorName;

    private Integer account_id;

    public TransferDTO(
        BigDecimal tValue,
        String tType,
        String operatorName,
        Integer account_id
    ){
        this.tValue = tValue;
        this.tType = tType;
        this.operatorName = operatorName;
        this.account_id = account_id;
    }

    public TransferDTO(){
        this.tValue = null;
        this.tType = "";
        this.operatorName = "";
        this.account_id = -1;
    }

    public BigDecimal gettValue() {
        return tValue;
    }

    public String gettType() {
        return tType;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public Integer getAccount_id() {
        return account_id;
    }
    
}
