package br.com.banco.core.usecases.account;

import java.util.List;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.dtos.NewAccountDTO;

//Define os casos de uso das contas
public interface AccountUseCase {
    
    public Account create(NewAccountDTO account) throws Exception;

    public List<Account> findAll();

    public Account findById(Integer id) throws Exception;

}