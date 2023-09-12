package br.com.banco.application.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.AccountDTO;
import br.com.banco.core.usecases.account.AccountUseCase;
import br.com.banco.presenter.account.AccountServices;

@Service
public class AccountServicesImpl implements AccountServices {

    @Autowired
    AccountUseCase accountUCase;

    @Override
    public Account createAccount(AccountDTO account) throws Exception {
        return accountUCase.create(account);
    }

    @Override
    public List<Account> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Account getById(Integer id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<Transfer> getTransfersByIdAccount(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTransfersByIdAccount'");
    }
    
}
