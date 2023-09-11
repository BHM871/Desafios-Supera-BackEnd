package br.com.banco.application.transfer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.core.domain.TransferModel;
import br.com.banco.core.usecases.transfers.TransferRepository;
import br.com.banco.presenter.TransferServices;

@Service
public class TransferServicesImpl implements TransferServices {
    
    @Autowired
    TransferRepository transferRepository;

    //Busca todas as tranferências
    @Override
    public List<TransferModel> findAll(){
        return transferRepository.findAll();
    }

    //Busca as tranferências baseados nos filtros disponíveis, por fim retorna a lista filtrada
    @Override
    public List<TransferModel> findWithFilter(long initial, long finals,  String name){
        List<TransferModel> transfers;

        if(!name.isEmpty() && (initial > 0 || finals > 0)){
            transfers = transferRepository.findByOperatorNameAndInterval(name, initial, finals);
        } else if (!name.isEmpty()){
            transfers = transferRepository.findByOperatorName(name);
        } else {
            transfers = transferRepository.findInInterval(initial, finals);
        }

        return transfers;
    }

}
