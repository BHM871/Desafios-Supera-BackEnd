package br.com.banco.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.models.TransferModel;
import br.com.banco.services.TransfersServices;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class TransferController {
    
    @Autowired
    TransfersServices transferServices;

    //Método para buscar todas as transferências
    @GetMapping("/")
    public ResponseEntity<List<TransferModel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(transferServices.findAll());
    }

    //Método para filtrar a busca pelas transferências
    @GetMapping("/filters")
    public ResponseEntity<List<TransferModel>> getWithFilter(
        @RequestParam(value = "initial", required = false, defaultValue = "0") String i,
        @RequestParam(value = "final", required = false, defaultValue = "0") String f, 
        @RequestParam(value = "name", required = false, defaultValue = "") String name
    ) {
        long initial = Long.valueOf(i);
        long finals = Long.valueOf(f);
        return ResponseEntity.status(HttpStatus.OK).body(transferServices.findWithFilter(initial, finals, name));
    }
    
}
