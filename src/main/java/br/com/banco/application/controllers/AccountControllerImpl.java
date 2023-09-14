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

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.AccountDTO;
import br.com.banco.core.usecases.presenter.account.AccountController;
import br.com.banco.core.usecases.presenter.account.AccountServices;

@RestController
@RequestMapping("/account")
public class AccountControllerImpl implements AccountController {

    @Autowired
    AccountServices services;

    @Override
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO account)  throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(services.create(account));
    }

    @Override
    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(services.findAll());
    }

    @Override
    @CrossOrigin
    @GetMapping("/byId")
    public ResponseEntity<Account> getById(@RequestBody AccountDTO account) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(services.findById(account.getId()));
    }
    
}
