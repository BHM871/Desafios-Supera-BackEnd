package br.com.banco.core.usecases.presenter.account;

import java.util.List;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.AccountDTO;

public interface AccountServices {
    
    public Account create(AccountDTO account) throws Exception;

    public List<Account> findAll();

    public Account findById(Integer id) throws Exception;

}
