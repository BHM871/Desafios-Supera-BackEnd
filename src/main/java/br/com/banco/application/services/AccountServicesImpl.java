package br.com.banco.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.dtos.AccountDTO;
import br.com.banco.core.usecases.account.AccountRepository;
import br.com.banco.core.usecases.account.AccountUseCase;

//Classe que implementa os casos de uso do Service das contas
@Service
public class AccountServicesImpl implements AccountUseCase {

    @Autowired
    AccountRepository repository;

    //Cira uma conta
    @Override
    public Account create(AccountDTO account) throws Exception {
        return repository.createAccount(account);
    }

    //Busca todas as contas
    @Override
    public List<Account> findAll() {
        return this.repository.findAll();
    }

    //Busca uma conta pelo ID
    @Override
    public Account findById(Integer id) throws Exception {
        return this.repository.findById(id);
    }
    
}