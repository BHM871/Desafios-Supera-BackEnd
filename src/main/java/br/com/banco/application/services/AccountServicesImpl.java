package br.com.banco.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.dtos.AccountDTO;
import br.com.banco.core.usecases.account.AccountUseCase;
import br.com.banco.core.usecases.presenter.account.AccountServices;

//Classe que implementa os casos de uso do Service das contas
@Service
public class AccountServicesImpl implements AccountServices {

    @Autowired
    AccountUseCase accountUCase;

    //Cira uma conta
    @Override
    public Account create(AccountDTO account) throws Exception {
        return accountUCase.create(account);
    }

    //Busca todas as contas
    @Override
    public List<Account> findAll() {
        return this.accountUCase.getAll();
    }

    //Busca uma conta pelo ID
    @Override
    public Account findById(Integer id) throws Exception {
        return this.accountUCase.getById(id);
    }
    
}