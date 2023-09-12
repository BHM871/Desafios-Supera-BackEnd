package br.com.banco.presenter.account;

import java.util.List;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.AccountDTO;

public interface AccountServices {
    
    public Account createAccount(AccountDTO account) throws Exception;

    public List<Account> getAll();

    public Account getById(Integer id) throws Exception;

    public List<Transfer> getTransfersByIdAccount(Integer id);

}
