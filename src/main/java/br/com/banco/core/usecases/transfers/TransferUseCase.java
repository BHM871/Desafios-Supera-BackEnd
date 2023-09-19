package br.com.banco.core.usecases.transfers;

import java.util.List;

import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.FiltersDTO;
import br.com.banco.core.domain.dtos.TransferDTO;

//Define os casos de uso das transferencias
public interface TransferUseCase {

    public Transfer create(TransferDTO transfer) throws Exception;
    
    public List<Transfer> findAll();

    public List<Transfer> findWithFilter(FiltersDTO search) throws Exception;

    public List<Transfer> findTransfersByIdAccount(int account) throws Exception;

}