package br.com.banco.application.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.TransferDTO;
import br.com.banco.core.domain.exceptions.InvalidArgumentException;
import br.com.banco.core.domain.exceptions.UserNotFoundException;
import br.com.banco.core.usecases.transfers.TransferRepository;
import br.com.banco.infra.jpa.JpaAccountRepository;
import br.com.banco.infra.jpa.JpaTransferRepository;

//Classe que implementa os casos de uso do Repository das transferências
@Repository
public class TransferRepositoryImpl implements TransferRepository  {

    @Autowired
    JpaTransferRepository thisRepository;
    @Autowired
    JpaAccountRepository accountRepository;

    //Salva uma transferência no bando de dados e retorna ela
    @Override
    public Transfer save(Transfer data) throws Exception{
        try{
            return thisRepository.save(data);
        } catch(Exception e){
            throw new InternalError("Não foi possivel salvar a transferência", e);
        }
    }

    //Cria uma transferência e salva
    @Override
    public Transfer createTransfer(TransferDTO transfer) throws Exception {
        validateTransfer(transfer);

        try{
            Transfer newTransfer = new Transfer(transfer);
            Account account = accountRepository.findById(transfer.getAccountId()).orElseThrow(() -> new UserNotFoundException());

            newTransfer.setTransferDate(LocalDateTime.now());
            newTransfer.setAccount(account);
            
            Long newTransferId = save(newTransfer).getId();
            newTransfer.setId(newTransferId);

            return newTransfer;
        } catch(UserNotFoundException e){
            throw e;
        }catch(Exception e){
            throw new InternalError("Não foi possivel fazer a transferencia", e);
        }
        
    }

    //Busca todas as transferências
    @Override
    public List<Transfer> findAll() {
        return thisRepository.findAll();
    }

    //Busca as transferências pelo nome do operador
    @Override
    public List<Transfer> findByOperatorName(String operatorName) {
        return thisRepository.findByOperatorName(operatorName);
    }
    
    //Busca as transferências pelo intervalo de tempo
    @Override
    public List<Transfer> findInInterval(LocalDateTime start, LocalDateTime end) {
        if(start == null) start = LocalDateTime.of(0, 0, 0, 0, 0);
        if(end == null) end = LocalDateTime.now();

        return  thisRepository.findByTransferDateBetween(start, end);
    }

    //Busca as transferências pelo nome do operador e pelo intervalo de tempo
    @Override
    public List<Transfer> findByOperatorNameAndInterval(String operatorName, LocalDateTime start, LocalDateTime end) {
        if(start == null) start = LocalDateTime.of(0, 0, 0, 0, 0);
        if(end == null) end = LocalDateTime.now();

        return thisRepository.findByOperatorNameAndTransferDateBetween(operatorName, start, end);
    }

    //Busca uma conta pelo ID depois busca as transferências dessa conta e retorna a lista de transferências
    @Override
    public List<Transfer> findTransfersByIdAccount(int id) throws Exception {
        Optional<Account> data = accountRepository.findById(id);
        
        if(!data.isPresent()) throw new UserNotFoundException();
        
        return thisRepository.findByAccount(data.get());
    }

    //Método para validar os dados antes de criar uma transferência
    private void validateTransfer(TransferDTO t) throws Exception {
        String message = "Não foi possivel fazer a transferência, algum valor está vazio";

        if(t.getOperatorName() != null && !t.getOperatorName().isEmpty()){
            accountRepository.findByNameResponsible(t.getOperatorName())
                .orElseThrow(
                    () -> new UserNotFoundException("Conta de destino não encontrada")
                );
        }
            
        if(t.getTValue() == null) throw new InvalidArgumentException(message);

        if(t.getTType() == null) throw new InvalidArgumentException(message);

        if(t.getAccountId() == null) throw new InvalidArgumentException(message);

    }

}