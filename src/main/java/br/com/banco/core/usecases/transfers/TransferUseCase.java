package br.com.banco.core.usecases.transfers;

import java.util.List;

import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.TransferDTO;

public interface TransferUseCase {
    
    public Transfer create(TransferDTO transfer) throws Exception;

    public List<Transfer> getAll();

    public List<Transfer> getByOperatorName(String name);

    public List<Transfer> getByInterval(long initial, long finals);

    public List<Transfer> getByOperatorNameAndInterval(String name, long initial, long finals);


}
