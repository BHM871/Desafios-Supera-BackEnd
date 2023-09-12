package br.com.banco.application.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.AccountDTO;
import br.com.banco.core.usecases.account.AccountRepository;
import br.com.banco.presenter.account.AccountServices;

@Component
public class AccountUseCaseImpl implements AccountServices {

    @Autowired
    AccountRepository repository;

    @Override
    public Account createAccount(AccountDTO account) throws Exception {
        return repository.createAccount(account);
    }

    @Override
    public List<Account> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Account getById(Integer id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Transfer> getTransfersByIdAccount(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    
    
}
