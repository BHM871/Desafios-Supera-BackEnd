package br.com.banco.application.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.AccountDTO;
import br.com.banco.presenter.account.AccountController;
import br.com.banco.presenter.account.AccountServices;

@RestController
public class AccountControllerImpl implements AccountController {

    @Autowired
    AccountServices services;

    @Override
    public ResponseEntity<Account> createAccount(AccountDTO account) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(services.createAccount(account));
    }

    @Override
    public ResponseEntity<List<Account>> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ResponseEntity<Account> getById(Integer id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public ResponseEntity<List<Transfer>> getTransfersByIdAccount(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTransfersByIdAccount'");
    }
    
}
