package br.com.banco.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.models.TransferModel;
import br.com.banco.repositories.TransferRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class TransferController {
    
    @Autowired
    TransferRepository transferRepository;

    @GetMapping("/tranfers")
    public ResponseEntity<List<TransferModel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(transferRepository.findAll());
    }
    
}
