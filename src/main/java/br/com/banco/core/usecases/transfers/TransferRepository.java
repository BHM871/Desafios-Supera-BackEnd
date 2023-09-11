package br.com.banco.core.usecases.transfers;

import java.util.List;

import br.com.banco.core.domain.TransferModel;

public interface TransferRepository {

    public List<TransferModel> findAll();

    public List<TransferModel> findByOperatorName(String operatorName);
    
    public List<TransferModel> findInInterval(long initial, long finals);

    public List<TransferModel> findByOperatorNameAndInterval(String operatorName, long initial, long finals);
    
}
