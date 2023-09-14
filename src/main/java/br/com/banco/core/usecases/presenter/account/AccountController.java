package br.com.banco.core.usecases.presenter.account;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.AccountDTO;

public interface AccountController {
    
    public ResponseEntity<Account> createAccount(AccountDTO account) throws Exception;

    public ResponseEntity<List<Account>> getAll();

    public ResponseEntity<Account> getById(AccountDTO id) throws Exception;

}
