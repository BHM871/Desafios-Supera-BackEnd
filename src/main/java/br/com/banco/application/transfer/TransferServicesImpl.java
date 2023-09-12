package br.com.banco.application.transfer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.commun.LocalDateTimeToLong;
import br.com.banco.core.domain.TransferModel;
import br.com.banco.core.domain.dtos.SearchDTO;
import br.com.banco.core.domain.dtos.TransferDTO;
import br.com.banco.core.usecases.transfers.TransferUseCase;
import br.com.banco.presenter.TransferServices;

@Service
public class TransferServicesImpl implements TransferServices {
    
    @Autowired
    TransferUseCase transferUCase;

    //Cria uma transferencia
    @Override
    public TransferModel create(TransferDTO transfer){
        return transferUCase.create(transfer);
    }

    //Busca todas as tranferências
    @Override
    public List<TransferModel> findAll(){
        return transferUCase.getAll();
    }

    //Busca as tranferências baseados nos filtros disponíveis, por fim retorna a lista filtrada
    @Override
    public List<TransferModel> findWithFilter(SearchDTO search){
        List<TransferModel> transfers;
        String name = search.getName();
        long initial = LocalDateTimeToLong.of(search.getInitial());
        long finals = LocalDateTimeToLong.of(search.getFinals());

        if(!name.isEmpty() && (initial > 0 || finals > 0)){
            transfers = transferUCase.getByOperatorNameAndInterval(name, initial, finals);
        } else if (!name.isEmpty()){
            transfers = transferUCase.getByOperatorName(name);
        } else {
            transfers = transferUCase.getByInterval(initial, finals);
        }

        return transfers;
    }

}
