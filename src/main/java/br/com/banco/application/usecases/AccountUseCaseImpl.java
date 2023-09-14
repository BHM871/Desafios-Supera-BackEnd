package br.com.banco.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.AccountDTO;
import br.com.banco.core.usecases.account.AccountRepository;
import br.com.banco.core.usecases.account.AccountUseCase;

@Component
public class AccountUseCaseImpl implements AccountUseCase {

    @Autowired
    AccountRepository repository;

    @Override
    public Account create(AccountDTO account) throws Exception {
        return this.repository.createAccount(account);
    }

    @Override
    public List<Account> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Account getById(Integer id) throws Exception {
        return this.repository.findById(id);
    }

}
