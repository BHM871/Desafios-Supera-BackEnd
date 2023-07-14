package br.com.banco.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.models.TransferModel;
import br.com.banco.repositories.TransferRepository;
import br.com.banco.services.TransfersServices;

import java.util.*;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class TransferController {
    
    @Autowired
    TransfersServices transferServices;

    @GetMapping("/tranfers")
    public ResponseEntity<List<TransferModel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(transferServices.findAll());
    }

    @GetMapping("/transfers?{initial}&{finals}")
    public ResponseEntity<List<TransferModel>> getWithFilter(
        @PathParam(value = "initial") long initial,
        @PathParam(value = "finals") long finals
    ) {
        return getWithFilter(initial, finals, "");
    }

    @GetMapping("/transfers?{name}")
    public ResponseEntity<List<TransferModel>> getWithFilter(
        @PathParam(value = "name") String name
    ) {
        return getWithFilter(0, 0, name);
    }

    @GetMapping("/transfers/{intial}&{finals}&{name}")
    public ResponseEntity<List<TransferModel>> getWithFilter(
        @PathParam(value = "initial") long initial,
        @PathParam(value = "finals") long finals, 
        @PathParam(value = "name") String name
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(transferServices.findWithFilter(initial, finals, name));
    }
    
}
