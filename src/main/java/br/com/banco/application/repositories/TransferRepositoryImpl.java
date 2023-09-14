package br.com.banco.application.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.TransferByAccountDTO;
import br.com.banco.core.domain.dtos.TransferDTO;
import br.com.banco.core.usecases.account.AccountRepository;
import br.com.banco.core.usecases.transfers.TransferRepository;
import br.com.banco.infra.jpa.JpaAccountRepository;
import br.com.banco.infra.jpa.JpaTransferRepository;

@Repository
public class TransferRepositoryImpl implements TransferRepository  {

    @Autowired
    JpaTransferRepository repository;
    @Autowired
    JpaAccountRepository accountRepository;

    @Override
    public Transfer save(Transfer data){
        return this.repository.save(data);
    }

    @Override
    public Transfer createTransfer(TransferDTO transfer) throws Exception {
        validateTransfer(transfer);

        Transfer newTransfer = new Transfer(transfer);
        Account account = accountRepository.findById(transfer.getAccountId()).orElseThrow();

        newTransfer.setTransferDate(LocalDateTime.now());
        newTransfer.setAccount(account);
        
        Long newTransferId = save(newTransfer).getId();
        newTransfer.setId(newTransferId);

        accountRepository.save(account);

        return newTransfer;
    }

    @Override
    public Transfer findById(Long id) throws Exception {
        return this.repository.findById(id).orElseThrow();
    }

    @Override
    public List<Transfer> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Transfer> findByOperatorName(String operatorName) {
        return this.repository.findByOperatorName(operatorName);
    }
    
    @Override
    public List<Transfer> findInInterval(LocalDateTime start, LocalDateTime end) {
        if(start == null) start = LocalDateTime.of(0, 0, 0, 0, 0);
        if(end == null) end = LocalDateTime.now();

        return  this.repository.findByTransferDateBetween(start, end);
    }

    @Override
    public List<Transfer> findByOperatorNameAndInterval(String operatorName, LocalDateTime start, LocalDateTime end) {
        if(start == null) start = LocalDateTime.of(0, 0, 0, 0, 0);
        if(end == null) end = LocalDateTime.now();

        return this.repository.findByOperatorNameAndTransferDateBetween(operatorName, start, end);
    }

    @Override
    public List<Transfer> findTransfersByIdAccount(TransferByAccountDTO account) throws Exception {
        Account data = accountRepository.findById(account.getId()).orElseThrow();
        
        return this.repository.findByAccount(data);
    }

    private void validateTransfer(TransferDTO t) throws Exception {
        String message = "Não foi possivel fazer a transferência, algum valor está incorreto";

        if(t.gettValue() == null) throw new Exception(message);

        if(t.gettType() == null) throw new Exception(message);

        if(t.getAccountId() == null) throw new Exception(message);

    }

}
