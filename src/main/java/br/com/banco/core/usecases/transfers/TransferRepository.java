package br.com.banco.core.usecases.transfers;

import java.util.List;

import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.TransferDTO;

public interface TransferRepository {

    public Transfer createUser(TransferDTO transfer) throws Exception;

    public void save(Transfer transfer);

    public List<Transfer> findAll();

    public List<Transfer> findByOperatorName(String operatorName);
    
    public List<Transfer> findInInterval(long initial, long finals);

    public List<Transfer> findByOperatorNameAndInterval(String operatorName, long initial, long finals);
    
}
