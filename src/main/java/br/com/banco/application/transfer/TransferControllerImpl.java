package br.com.banco.application.transfer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.SearchDTO;
import br.com.banco.core.domain.dtos.TransferDTO;
import br.com.banco.presenter.transfer.TransferController;
import br.com.banco.presenter.transfer.TransferServices;

@RestController
public class TransferControllerImpl implements TransferController {
    
    @Autowired
    TransferServices transferServices;

    //Criar novas transferencias
    @Override
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Transfer> createTransfer(@RequestBody TransferDTO transfer)  throws Exception {
        Transfer a = transferServices.create(transfer);
        return ResponseEntity.status(HttpStatus.CREATED).body(a);
    }

    //Método para buscar todas as transferências
    @Override
    @CrossOrigin
    @GetMapping("/") 
    public ResponseEntity<List<Transfer>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(transferServices.findAll());
    }

    //Método para filtrar a busca pelas transferências
    @Override
    @CrossOrigin
    @GetMapping("/filters")
    public ResponseEntity<List<Transfer>> getWithFilter(@RequestBody SearchDTO search) throws Exception {
        List<Transfer> a = transferServices.findWithFilter(search);
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }
    
}
