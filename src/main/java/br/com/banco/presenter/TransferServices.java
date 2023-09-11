package br.com.banco.presenter;

import java.util.List;

import br.com.banco.core.domain.TransferModel;
import br.com.banco.core.domain.dto.TransferDTO;

public interface TransferServices {

    public TransferModel create(TransferDTO transfer);
    
    public List<TransferModel> findAll();

    public List<TransferModel> findWithFilter(long initial, long finals,  String name);

}
