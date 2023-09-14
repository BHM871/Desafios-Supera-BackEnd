package br.com.banco.core.usecases.transfers;

import java.time.LocalDateTime;
import java.util.List;

import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.TransferByAccountDTO;
import br.com.banco.core.domain.dtos.TransferDTO;

//Define os casos de uso da transferencia
public interface TransferUseCase {
    
    public Transfer create(TransferDTO transfer) throws Exception;

    public List<Transfer> getAll();

    public List<Transfer> getByOperatorName(String name);

    public List<Transfer> getByInterval(LocalDateTime start, LocalDateTime end);

    public List<Transfer> getByOperatorNameAndInterval(String name, LocalDateTime start, LocalDateTime end);

    public List<Transfer> getTransfersByIdAccount(TransferByAccountDTO account) throws Exception;

}