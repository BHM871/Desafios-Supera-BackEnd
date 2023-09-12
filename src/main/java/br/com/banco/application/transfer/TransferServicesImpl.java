package br.com.banco.application.transfer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.commun.LocalDateTimeToLong;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.SearchDTO;
import br.com.banco.core.domain.dtos.TransferDTO;
import br.com.banco.core.usecases.transfers.TransferUseCase;
import br.com.banco.presenter.transfer.TransferServices;

@Service
public class TransferServicesImpl implements TransferServices {
    
    @Autowired
    TransferUseCase transferUCase;

    //Cria uma transferencia
    @Override
    public Transfer create(TransferDTO transfer) throws Exception {
        return transferUCase.create(transfer);
    }

    //Busca todas as tranferências
    @Override
    public List<Transfer> findAll(){
        return transferUCase.getAll();
    }

    //Busca as tranferências baseados nos filtros disponíveis, por fim retorna a lista filtrada
    @Override
    public List<Transfer> findWithFilter(SearchDTO search) throws Exception {
        String name = search.getName();
        long initial = LocalDateTimeToLong.of(search.getInitial());
        long finals = LocalDateTimeToLong.of(search.getFinals());

        if(!name.isEmpty() && (initial > 0 || finals > 0)){
            return transferUCase.getByOperatorNameAndInterval(name, initial, finals);
        }
        
        if (!name.isEmpty()){
            return transferUCase.getByOperatorName(name);
        } 
        
        if(initial > 0 || finals > 0) {
            return transferUCase.getByInterval(initial, finals);
        }

        throw new Exception("Filtros inválidos");

    }

}
