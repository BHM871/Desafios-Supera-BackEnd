package br.com.banco.core.usecases.presenter.transfer;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.FiltersDTO;
import br.com.banco.core.domain.dtos.TransferByAccountDTO;
import br.com.banco.core.domain.dtos.TransferDTO;

//Mapeia os casos de uso do Controller das transferências
public interface TransferController {

    public ResponseEntity<Transfer> createTransfer(TransferDTO transfer)  throws Exception;
    
    public ResponseEntity<List<Transfer>> getAll();

    public ResponseEntity<List<Transfer>> getWithFilter(FiltersDTO search) throws Exception;

    public ResponseEntity<List<Transfer>> getTransfersByIdAccount(TransferByAccountDTO account) throws Exception;
    
}
