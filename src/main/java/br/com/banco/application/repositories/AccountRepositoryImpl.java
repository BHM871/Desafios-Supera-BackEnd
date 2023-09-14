package br.com.banco.application.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.AccountDTO;
import br.com.banco.core.usecases.account.AccountRepository;
import br.com.banco.core.usecases.transfers.TransferRepository;
import br.com.banco.infra.jpa.JpaAccountRepository;
import br.com.banco.infra.jpa.JpaTransferRepository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    JpaAccountRepository repository;
    @Autowired
    JpaTransferRepository transferRepository;

    @Override
    public void save(Account data) {
        this.repository.save(data);
    }

    @Override
    public Account createAccount(AccountDTO account) throws Exception {
        validateAccount(account);

        Account newAccount = new Account(account);

        save(newAccount);
        return newAccount;
    }

    @Override
    public List<Account> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Account findById(Integer id) throws Exception {
        return this.repository.findById(id).orElseThrow();
    }
    
    private void validateAccount(AccountDTO a) throws Exception {
        if(a.getNameResponsible() == null || a.getNameResponsible().isEmpty()) throw new Exception("Nome está inválido");
    }

}
