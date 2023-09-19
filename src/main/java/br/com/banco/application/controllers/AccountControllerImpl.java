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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.dtos.NewAccountDTO;
import br.com.banco.core.domain.exceptions.ExceptionBody;
import br.com.banco.core.usecases.account.AccountController;
import br.com.banco.core.usecases.account.AccountUseCase;
import br.com.banco.core.usecases.exceptions.ExceptionManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Autowired
    ExceptionManager exceptionManager;

    //Cria uma nova conta e salva no banco de dados
    @Override
    @CrossOrigin
    @PostMapping("/create")
    @Operation(summary = "Create a new account")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Returns a new account"),
        @ApiResponse(responseCode = "422", description = "Invalid Arguments", content = @Content(schema = @Schema(type = "object", implementation = ExceptionBody.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(type = "object", implementation = ExceptionBody.class)))
    })
    public ResponseEntity<Account> createAccount(@RequestBody NewAccountDTO account)  throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(services.create(account));            
    }

    //Método para buscar todas as contas
    @Override
    @CrossOrigin
    @GetMapping("/")
    @Operation(summary = "Get all accounts")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns a list of account or a empty list")
    })
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(services.findAll());
    }

    //Método para buscar uma conta pelo ID
    @Override
    @CrossOrigin
    @GetMapping("/by{id}")
    @Operation(summary = "Get a account with ID", parameters = @Parameter(name = "id", required = true))
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns a account"),
        @ApiResponse(responseCode = "404", description = "User Not Found", content = @Content(schema = @Schema(type = "object", implementation = ExceptionBody.class))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(type = "object", implementation = ExceptionBody.class)))
    })
    public ResponseEntity<Account> getById(@RequestParam(name = "id", required = true) int id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(services.findById(id));
    }

}