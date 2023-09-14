package br.com.banco.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.commun.LocalDateTimeConv;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.FiltersDTO;
import br.com.banco.core.domain.dtos.TransferByAccountDTO;
import br.com.banco.core.domain.dtos.TransferDTO;
import br.com.banco.core.usecases.presenter.transfer.TransferServices;
import br.com.banco.core.usecases.transfers.TransferUseCase;

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
    public List<Transfer> findWithFilter(FiltersDTO search) throws Exception {
        String name = search.getName();
        long start = LocalDateTimeConv.toLong(search.getStart());
        long end = LocalDateTimeConv.toLong(search.getEnd());

        if(!name.isEmpty() && (start > 0 || end > 0)){
            return transferUCase.getByOperatorNameAndInterval(name, search.getStart(), search.getEnd());
        }
        
        if (!name.isEmpty()){
            return transferUCase.getByOperatorName(name);
        } 
        
        if(start > 0 || end > 0) {
            return transferUCase.getByInterval(search.getStart(), search.getEnd());
        }

        throw new Exception("Filtros inválidos");

    }
    @Override
    public List<Transfer> findTransfersByIdAccount(TransferByAccountDTO account) throws Exception {
        return this.transferUCase.getTransfersByIdAccount(account);
    }

}
