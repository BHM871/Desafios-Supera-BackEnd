package br.com.banco.application.transfer;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.banco.core.domain.TransferModel;
import br.com.banco.core.domain.dto.TransferDTO;
import br.com.banco.core.usecases.transfers.TransferRepository;
import br.com.banco.core.usecases.transfers.TransferUseCase;

@Component
public class TransferUseCaseImpl implements TransferUseCase {

    @Autowired
    TransferRepository repository;

    @Override
    public TransferModel create(TransferDTO transfer) {
        validate(transfer);

        TransferModel newTransfer = new TransferModel();

        newTransfer.setTransferDate(LocalDateTime.now());
        newTransfer.setValue(transfer.gettValue());
        newTransfer.setOperatorName(transfer.getOperatorName());
        newTransfer.setAccount_id(transfer.getAccount_id());

        return repository.create(newTransfer);
    }

    @Override
    public List<TransferModel> getAll() {
        return repository.findAll();
    }

    @Override
    public List<TransferModel> getByOperatorName(String name) {
        return repository.findByOperatorName(name);
    }

    @Override
    public List<TransferModel> getByInterval(long initial, long finals) {
        return repository.findInInterval(initial, finals);
    }

    @Override
    public List<TransferModel> getByOperatorNameAndInterval(String name, long initial, long finals) {
        return repository.findByOperatorNameAndInterval(name, initial, finals);
    }

    private void validate(TransferDTO t){

        if(t.gettValue() == null) throw new ExceptionInInitializerError();

        if(t.gettType() == null || t.gettType().isEmpty()) throw new ExceptionInInitializerError();

        if(t.getOperatorName() == null || t.getOperatorName().isEmpty()) throw new ExceptionInInitializerError();

        if(t.getAccount_id() == null || t.getAccount_id() == 0) throw new ExceptionInInitializerError();

    }
    
}
