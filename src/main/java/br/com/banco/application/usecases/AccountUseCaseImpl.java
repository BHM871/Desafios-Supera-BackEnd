package br.com.banco.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.dtos.AccountDTO;
import br.com.banco.core.usecases.account.AccountRepository;
import br.com.banco.core.usecases.account.AccountUseCase;

//Classe que implementa os casos de uso das contas
@Component
public class AccountUseCaseImpl implements AccountUseCase {

    @Autowired
    AccountRepository repository;

    //Cria uma conta
    @Override
    public Account create(AccountDTO account) throws Exception {
        return this.repository.createAccount(account);
    }

    //Busca todas as contas
    @Override
    public List<Account> getAll() {
        return this.repository.findAll();
    }

    //Busca as contas pelo ID
    @Override
    public Account getById(Integer id) throws Exception {
        return this.repository.findById(id);
    }

}