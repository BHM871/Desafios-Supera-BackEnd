package br.com.banco.presenter;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.banco.core.domain.TransferModel;
import br.com.banco.core.domain.dtos.SearchDTO;
import br.com.banco.core.domain.dtos.TransferDTO;

public interface TransferController {

    public ResponseEntity<TransferModel> createTransfer(TransferDTO transfer);
    
    public ResponseEntity<List<TransferModel>> getAll();

    public ResponseEntity<List<TransferModel>> getWithFilter(SearchDTO search);
    
}
