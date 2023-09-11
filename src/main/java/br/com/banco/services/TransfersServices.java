package br.com.banco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.models.TransferModel;
import br.com.banco.repositories.TransferRepository;

@Service
public class TransfersServices {
    
    @Autowired
    TransferRepository transferRepository;

    //Busca todas as tranferências
    public List<TransferModel> findAll(){
        return transferRepository.findAll();
    }

    //Busca as tranferências baseados nos filtros disponíveis, por fim retorna a lista filtrada
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
