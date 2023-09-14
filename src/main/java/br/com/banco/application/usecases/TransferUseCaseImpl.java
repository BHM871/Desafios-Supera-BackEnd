package br.com.banco.application.usecases;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.TransferByAccountDTO;
import br.com.banco.core.domain.dtos.TransferDTO;
import br.com.banco.core.usecases.transfers.TransferRepository;
import br.com.banco.core.usecases.transfers.TransferUseCase;

//Classe que implementa os casos de uso das transferências
@Component
public class TransferUseCaseImpl implements TransferUseCase {

    @Autowired
    TransferRepository repository;

    //Cria uma transferência
    @Override
    public Transfer create(TransferDTO transfer) throws Exception {
        return repository.createTransfer(transfer);
    }

    //Busca todas as transferências
    @Override
    public List<Transfer> getAll() {
        return repository.findAll();
    }

    //Busca as transferências pelo nome do operador
    @Override
    public List<Transfer> getByOperatorName(String name) {
        return repository.findByOperatorName(name);
    }

    //Busca as transferências pelo intervalo de tempo
    @Override
    public List<Transfer> getByInterval(LocalDateTime start, LocalDateTime end) {
        return repository.findInInterval(start, end);
    }

    //Busca as transferências pelo nome do operador e pelo intervalo de tempo
    @Override
    public List<Transfer> getByOperatorNameAndInterval(String name, LocalDateTime start, LocalDateTime end) {
        return repository.findByOperatorNameAndInterval(name, start, end);
    }

    //Busca as transferências de uma conta pelo ID
    @Override
    public List<Transfer> getTransfersByIdAccount(TransferByAccountDTO account) throws Exception {
        return this.repository.findTransfersByIdAccount(account);
    }
    
}