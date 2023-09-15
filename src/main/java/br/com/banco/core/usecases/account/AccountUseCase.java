package br.com.banco.core.usecases.account;

import java.util.List;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.dtos.AccountDTO;

//Define os casos de uso das contas
public interface AccountUseCase {
    
    public Account create(AccountDTO account) throws Exception;

    public List<Account> findAll();

    public Account findById(Integer id) throws Exception;

}