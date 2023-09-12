package br.com.banco.presenter.transfer;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.SearchDTO;
import br.com.banco.core.domain.dtos.TransferDTO;

public interface TransferController {

    public ResponseEntity<Transfer> createTransfer(TransferDTO transfer)  throws Exception;
    
    public ResponseEntity<List<Transfer>> getAll();

    public ResponseEntity<List<Transfer>> getWithFilter(SearchDTO search) throws Exception;
    
}
