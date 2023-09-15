package br.com.banco.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.FiltersDTO;
import br.com.banco.core.domain.dtos.TransferByAccountDTO;
import br.com.banco.core.domain.dtos.TransferDTO;
import br.com.banco.core.usecases.transfers.TransferRepository;
import br.com.banco.core.usecases.transfers.TransferUseCase;

//Classe que implementa os casos de uso do Service das transferências
@Service
public class TransferServicesImpl implements TransferUseCase {
    
    @Autowired
    TransferRepository repository;

    //Cria uma transferencia
    @Override
    public Transfer create(TransferDTO transfer) throws Exception {
        return repository.createTransfer(transfer);
    }

    //Busca todas as tranferências
    @Override
    public List<Transfer> findAll(){
        return repository.findAll();
    }

    //Busca as tranferências baseados nos filtros disponíveis, por fim retorna a lista filtrada
    @Override
    public List<Transfer> findWithFilter(FiltersDTO search) throws Exception {
        String name = search.getName();

        if(!name.isEmpty() && (search.getStart().getYear() > 0 || search.getEnd().getYear() > 0)){
            return repository.findByOperatorNameAndInterval(name, search.getStart(), search.getEnd());
        }
        
        if (!name.isEmpty()){
            return repository.findByOperatorName(name);
        } 
        
        if(search.getStart().getYear() > 0 || search.getEnd().getYear() > 0) {
            return repository.findInInterval(search.getStart(), search.getEnd());
        }

        throw new Exception("Filtros inválidos");

    }

    //Buscas as transferencias de uma conta pelo ID
    @Override
    public List<Transfer> findTransfersByIdAccount(TransferByAccountDTO account) throws Exception {
        return this.repository.findTransfersByIdAccount(account);
    }

}