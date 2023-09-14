package br.com.banco.core.usecases.transfers;

import java.time.LocalDateTime;
import java.util.List;

import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.TransferByAccountDTO;
import br.com.banco.core.domain.dtos.TransferDTO;

public interface TransferRepository {

    public Transfer save(Transfer transfer);

    public Transfer createTransfer(TransferDTO transfer) throws Exception;

    public List<Transfer> findAll();

    public List<Transfer> findByOperatorName(String operatorName);
    
    public List<Transfer> findInInterval(LocalDateTime start, LocalDateTime end);

    public List<Transfer> findByOperatorNameAndInterval(String operatorName, LocalDateTime start, LocalDateTime end);
    
    public List<Transfer> findTransfersByIdAccount(TransferByAccountDTO id) throws Exception;
    
}
