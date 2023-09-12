package br.com.banco.application.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.AccountDTO;
import br.com.banco.core.usecases.account.AccountRepository;
import br.com.banco.infra.jpa.JpaAccountRepository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    JpaAccountRepository repository;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Account> findById(Integer Id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Transfer> findTransfersByIdAccount(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findTransfersByIdAccount'");
    }
    
    private void validateAccount(AccountDTO a) throws Exception {
        if(a.getNameResponsible() == null || a.getNameResponsible().isEmpty()) throw new Exception("Nome está inválido");
    }

}
