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

@Component
public class TransferUseCaseImpl implements TransferUseCase {

    @Autowired
    TransferRepository repository;

    @Override
    public Transfer create(TransferDTO transfer) throws Exception {
        return repository.createTransfer(transfer);
    }

    @Override
    public List<Transfer> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Transfer> getByOperatorName(String name) {
        return repository.findByOperatorName(name);
    }

    @Override
    public List<Transfer> getByInterval(LocalDateTime start, LocalDateTime end) {
        return repository.findInInterval(start, end);
    }

    @Override
    public List<Transfer> getByOperatorNameAndInterval(String name, LocalDateTime start, LocalDateTime end) {
        return repository.findByOperatorNameAndInterval(name, start, end);
    }
    @Override
    public List<Transfer> getTransfersByIdAccount(TransferByAccountDTO account) throws Exception {
        return this.repository.findTransfersByIdAccount(account);
    }
    
}
