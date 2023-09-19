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
import br.com.banco.core.domain.exceptions.ExceptionBody;
import br.com.banco.core.usecases.transfers.TransferController;
import br.com.banco.core.usecases.transfers.TransferUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

//Classe que implementa os casos de uso do Controller das transferências
@RestController
@RequestMapping(value = "/transfer", produces = {"application/json"})
@Tag(name = "Transfer")
public class TransferControllerImpl implements TransferController {
    
    @Autowired()
    TransferUseCase services;

    //Criar novas transferencias
    @Override
    @CrossOrigin
    @PostMapping("/create")
    @Operation(summary = "Create a new transfer")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Returns a new transfer"),
        @ApiResponse(responseCode = "400", description = "Source account or target account not found", content = @Content(schema = @Schema(type = "object", implementation = ExceptionBody.class))),
        @ApiResponse(responseCode = "422", description = "Invalid Arguments", content = @Content(schema = @Schema(type = "object", implementation = ExceptionBody.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(type = "object", implementation = ExceptionBody.class)))
    })
    public ResponseEntity<Transfer> createTransfer(@RequestBody TransferDTO transfer)  throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(services.create(transfer));
    }

    //Método para buscar todas as transferências
    @Override
    @CrossOrigin
    @GetMapping("/")
    @Operation(summary = "Get all transfers", description = "RequestBody is required, but, values of json is not required")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns a list of transfer or a empty list")
    })
    public ResponseEntity<List<Transfer>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(services.findAll());
    }

    //Método para filtrar a busca pelas transferências
    @Override
    @CrossOrigin
    @GetMapping("/filters")
    @Operation(summary = "Get transfers with filters", description = "RequestBody is required, but, all values of json not")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns a list of transfer or a empty list"),
        @ApiResponse(responseCode = "422", description = "All value are null", content = @Content(schema = @Schema(type = "object", implementation = ExceptionBody.class)))
    })
    public ResponseEntity<List<Transfer>> getWithFilter(@RequestBody FiltersDTO search) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(services.findWithFilter(search));
    }

    //Método para buscar as transferencias de uma conta pelo ID
    @Override
    @CrossOrigin
    @GetMapping("/byAccount")
    @Operation(summary = "Get transfers with account ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns a list of transfer from a account ID or a empty list"),
        @ApiResponse(responseCode = "400", description = "Account not found", content = @Content(schema = @Schema(type = "object", implementation = ExceptionBody.class)))
    })
    public ResponseEntity<List<Transfer>> getTransfersByIdAccount(@RequestBody TransferByAccountDTO account) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(services.findTransfersByIdAccount(account));
    }
    
}