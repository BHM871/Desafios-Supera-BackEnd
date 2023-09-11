package br.com.banco.presenter;

import java.util.List;

import br.com.banco.core.domain.TransferModel;

public interface TransferServices {
    
    public List<TransferModel> findAll();

    public List<TransferModel> findWithFilter(long initial, long finals,  String name);

}
