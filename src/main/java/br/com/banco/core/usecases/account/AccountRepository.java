package br.com.banco.core.usecases.account;

import java.util.List;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.dtos.AccountDTO;

//Define os casos de uso do repositório das contas
public interface AccountRepository {
    
    public void save(Account data) throws Exception;

    public Account createAccount(AccountDTO account) throws Exception;

    public List<Account> findAll();

    public Account findById(Integer id) throws Exception;

}