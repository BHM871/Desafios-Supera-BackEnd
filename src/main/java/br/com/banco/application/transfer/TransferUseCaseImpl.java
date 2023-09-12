package br.com.banco.application.transfer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.TransferDTO;
import br.com.banco.core.usecases.transfers.TransferRepository;
import br.com.banco.core.usecases.transfers.TransferUseCase;

@Component
public class TransferUseCaseImpl implements TransferUseCase {

    @Autowired
    TransferRepository repository;

    @Override
    public Transfer create(TransferDTO transfer) throws Exception {
        return repository.createUser(transfer);
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
    public List<Transfer> getByInterval(long initial, long finals) {
        return repository.findInInterval(initial, finals);
    }

    @Override
    public List<Transfer> getByOperatorNameAndInterval(String name, long initial, long finals) {
        return repository.findByOperatorNameAndInterval(name, initial, finals);
    }
    
}
