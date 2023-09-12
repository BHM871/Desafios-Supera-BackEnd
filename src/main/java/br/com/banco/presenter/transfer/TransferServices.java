package br.com.banco.presenter.transfer;

import java.util.List;

import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.SearchDTO;
import br.com.banco.core.domain.dtos.TransferDTO;

public interface TransferServices {

    public Transfer create(TransferDTO transfer) throws Exception;
    
    public List<Transfer> findAll();

    public List<Transfer> findWithFilter(SearchDTO search) throws Exception;

}
