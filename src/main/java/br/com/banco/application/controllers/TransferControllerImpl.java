package br.com.banco.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.FiltersDTO;
import br.com.banco.core.domain.dtos.TransferByAccountDTO;
import br.com.banco.core.domain.dtos.TransferDTO;
import br.com.banco.core.usecases.transfers.TransferController;
import br.com.banco.core.usecases.transfers.TransferUseCase;

//Classe que implementa os casos de uso do Controller das transferências
@RestController
@RequestMapping("/transfer")
public class TransferControllerImpl implements TransferController {
    
    @Autowired()
    TransferUseCase services;

    //Criar novas transferencias
    @Override
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Transfer> createTransfer(@RequestBody TransferDTO transfer)  throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(services.create(transfer));
    }

    //Método para buscar todas as transferências
    @Override
    @CrossOrigin
    @GetMapping("/") 
    public ResponseEntity<List<Transfer>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(services.findAll());
    }

    //Método para filtrar a busca pelas transferências
    @Override
    @CrossOrigin
    @GetMapping("/filters")
    public ResponseEntity<List<Transfer>> getWithFilter(@RequestBody FiltersDTO search) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(services.findWithFilter(search));
    }

    //Método para buscar as transferencias de uma conta pelo ID
    @Override
    @CrossOrigin
    @GetMapping("/byAccount")
    public ResponseEntity<List<Transfer>> getTransfersByIdAccount(@RequestBody TransferByAccountDTO account) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(services.findTransfersByIdAccount(account));
    }
    
}