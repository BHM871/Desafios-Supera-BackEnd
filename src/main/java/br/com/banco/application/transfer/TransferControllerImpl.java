package br.com.banco.application.transfer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.core.domain.TransferModel;
import br.com.banco.core.domain.dtos.SearchDTO;
import br.com.banco.core.domain.dtos.TransferDTO;
import br.com.banco.presenter.TransferController;
import br.com.banco.presenter.TransferServices;

@RestController
public class TransferControllerImpl implements TransferController {
    
    @Autowired
    TransferServices transferServices;

    //Criar novas transferencias
    @Override
    @CrossOrigin
    @GetMapping("create")
    public ResponseEntity<TransferModel> createTransfer(@RequestBody TransferDTO transfer){
        return ResponseEntity.status(HttpStatus.CREATED).body(transferServices.create(transfer));
    }

    //Método para buscar todas as transferências
    @Override
    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<List<TransferModel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(transferServices.findAll());
    }

    //Método para filtrar a busca pelas transferências
    @Override
    @CrossOrigin
    @GetMapping("filters")
    public ResponseEntity<List<TransferModel>> getWithFilter(@RequestBody SearchDTO search) {
        return ResponseEntity.status(HttpStatus.OK).header("TransferHeader").body(transferServices.findWithFilter(search));
    }
    
}
