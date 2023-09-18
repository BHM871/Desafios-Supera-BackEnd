package br.com.banco.core.usecases.account;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.dtos.GetByIdAccountDTO;
import br.com.banco.core.domain.dtos.NewAccountDTO;

//Mapeia os casos de uso do Controller das contas
public interface AccountController {
    
    public ResponseEntity<Account> createAccount(NewAccountDTO account) throws Exception;

    public ResponseEntity<List<Account>> getAll();

    public ResponseEntity<Account> getById(GetByIdAccountDTO id) throws Exception;

}