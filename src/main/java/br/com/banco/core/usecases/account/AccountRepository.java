package br.com.banco.core.usecases.account;

import java.util.List;
import java.util.Optional;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.AccountDTO;

public interface AccountRepository {
    
    public void save(Account data);

    public Account createAccount(AccountDTO account) throws Exception;

    public List<Account> findAll();

    public Optional<Account> findById(Integer Id) throws Exception;

    public List<Transfer> findTransfersByIdAccount(Integer id);

}
