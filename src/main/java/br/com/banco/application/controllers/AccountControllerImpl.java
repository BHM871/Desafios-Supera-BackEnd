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
import br.com.banco.core.domain.dtos.AccountDTO;
import br.com.banco.core.usecases.account.AccountController;
import br.com.banco.core.usecases.account.AccountUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

//Classe que implementa os casos de uso do Controller das contas
@RestController
@RequestMapping(value = "/account", produces = {"application/json"})
@Tag(name = "Account")
public class AccountControllerImpl implements AccountController {

    @Autowired
    AccountUseCase services;

    //Cria uma nova conta e salva no banco de dados
    @Override
    @CrossOrigin
    @PostMapping("/create")
    @Operation(summary = "Create a new account")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns a new account"),
        @ApiResponse(responseCode = "422", description = "Invalid Arguments"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO account)  throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(services.create(account));
    }

    //Método para buscar todas as contas
    @Override
    @CrossOrigin
    @GetMapping("/")
    @Operation(summary = "Get all accounts")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns a list of accountsa or a empty list")
    })
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(services.findAll());
    }

    //Método para buscar uma conta pelo ID
    @Override
    @CrossOrigin
    @GetMapping("/byId")
    @Operation(summary = "Get a account with ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns a account"),
        @ApiResponse(responseCode = "422", description = "ID not represent a account ID")
    })
    public ResponseEntity<Account> getById(@RequestBody AccountDTO account) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(services.findById(account.getId()));
    }

}