package br.com.banco.core.usecases.transfers;

import java.util.List;

import br.com.banco.core.domain.TransferModel;
import br.com.banco.core.domain.dto.TransferDTO;

public interface TransferUseCase {
    
    public TransferModel create(TransferDTO transfer);

    public List<TransferModel> getAll();

    public List<TransferModel> getByOperatorName(String name);

    public List<TransferModel> getByInterval(long initial, long finals);

    public List<TransferModel> getByOperatorNameAndInterval(String name, long initial, long finals);


}
