package br.com.banco.core.usecases.presenter.transfer;

import java.util.List;

import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.FiltersDTO;
import br.com.banco.core.domain.dtos.TransferByAccountDTO;
import br.com.banco.core.domain.dtos.TransferDTO;

//Define os casos de uso do Service das transferencias
public interface TransferServices {

    public Transfer create(TransferDTO transfer) throws Exception;
    
    public List<Transfer> findAll();

    public List<Transfer> findWithFilter(FiltersDTO search) throws Exception;

    public List<Transfer> findTransfersByIdAccount(TransferByAccountDTO account) throws Exception;

}