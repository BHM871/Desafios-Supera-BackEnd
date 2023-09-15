package br.com.banco.core.usecases.account;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.dtos.AccountDTO;

//Mapeia os casos de uso do Controller das contas
public interface AccountController {
    
    public ResponseEntity<Account> createAccount(AccountDTO account) throws Exception;

    public ResponseEntity<List<Account>> getAll();

    public ResponseEntity<Account> getById(AccountDTO id) throws Exception;

}