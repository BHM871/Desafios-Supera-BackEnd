package br.com.banco.core.usecases.account;

import java.util.List;
import java.util.Optional;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.AccountDTO;

public interface AccountUseCase {

    public Account create(AccountDTO account) throws Exception;

    public List<Account> getAll();

    public Optional<Account> getById(Integer Id) throws Exception;

    public List<Transfer> getTransfersByIdAccount(Integer id);

}
