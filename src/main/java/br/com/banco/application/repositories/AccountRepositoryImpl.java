package br.com.banco.application.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.dtos.NewAccountDTO;
import br.com.banco.core.domain.exceptions.InvalidArgumentException;
import br.com.banco.core.domain.exceptions.UserNotFoundException;
import br.com.banco.core.usecases.account.AccountRepository;
import br.com.banco.infra.jpa.JpaAccountRepository;
import br.com.banco.infra.jpa.JpaTransferRepository;

//Classe que implementa os casos de uso do Repository das contas
@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    JpaAccountRepository thisRepository;
    @Autowired
    JpaTransferRepository transferRepository;

    //Salva uma conta no banco de dados
    @Override
    public void save(Account data) throws Exception {
        try{
            thisRepository.save(data);
        } catch(Exception e){
            throw new InternalError("Não foi possivel salvar conta", e);
        }
    }

    //Valida as informacoes passadas para criacao da conta, cria a conta e salva
    @Override
    public Account createAccount(NewAccountDTO account) throws Exception {
        validateAccount(account);

        try{
            Account newAccount = new Account(account);

            save(newAccount);
            return newAccount;
        } catch(Exception e){
            throw new InternalError("Não foi possivel criar a conta", e);
        }
        
    }

    //Busca todas as contas salvas
    @Override
    public List<Account> findAll() {
        return thisRepository.findAll();
    }

    //Busca as contas pelo ID
    @Override
    public Account findById(Integer id) throws Exception {
        return thisRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
    }

    //Método para validar as informacoes para poder criar uma conta
    private void validateAccount(NewAccountDTO a) throws Exception {
        if(a.getNameResponsible() == null || a.getNameResponsible().isEmpty()) {
            throw new InvalidArgumentException("Nome tem um valor inválido");
        }
    }

}