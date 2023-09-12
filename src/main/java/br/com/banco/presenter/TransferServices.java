package br.com.banco.presenter;

import java.util.List;

import br.com.banco.core.domain.TransferModel;
import br.com.banco.core.domain.dtos.SearchDTO;
import br.com.banco.core.domain.dtos.TransferDTO;

public interface TransferServices {

    public TransferModel create(TransferDTO transfer);
    
    public List<TransferModel> findAll();

    public List<TransferModel> findWithFilter(SearchDTO search);

}
