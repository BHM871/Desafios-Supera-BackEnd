package br.com.banco.application.transfer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.banco.commun.LocalDateTimeToLong;
import br.com.banco.core.domain.Transfer;
import br.com.banco.core.domain.dtos.TransferDTO;
import br.com.banco.core.usecases.transfers.TransferRepository;
import br.com.banco.infra.jpa.JpaTransferRepository;

@Repository
public class TransferRepositoryImpl implements TransferRepository  {

    @Autowired
    private JpaTransferRepository repository;

    @Override
    public Transfer createUser(TransferDTO transfer) throws Exception {

        validateTransfer(transfer);

        Transfer newTransfer = new Transfer();

        newTransfer.setTransferDate(LocalDateTime.now());
        newTransfer.setValue(transfer.gettValue());
        newTransfer.setType(transfer.gettType());
        newTransfer.setOperatorName(transfer.getOperatorName());
        //newTransfer.setAccount(transfer.getAccount());

        save(newTransfer);
        return newTransfer;
    }

    @Override
    public void save(Transfer data){
        this.repository.save(data);
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
    public List<Transfer> findInInterval(long initial, long finals) {
        List<Transfer> transfers = findAll();
        transfers = applyFilterInterval(initial, finals, transfers);

        return transfers;
    }

    @Override
    public List<Transfer> findByOperatorNameAndInterval(String operatorName, long initial, long finals) {

        List<Transfer> transfers = findByOperatorName(operatorName);
        transfers = applyFilterInterval(initial, finals, transfers);

        return transfers;
    }

    private void validateTransfer(TransferDTO t)  {
        String message = "Não foi possivel fazer a trnaferência, algum valor está incorreto";

        if(t.gettValue() == null) throw new ExceptionInInitializerError(message);

        if(t.gettType() == null) throw new ExceptionInInitializerError(message);

        if(t.getOperatorName() == null || t.getOperatorName().isEmpty()) throw new ExceptionInInitializerError(message);

        if(t.getAccountId() == null || t.getAccountId() == 0) throw new ExceptionInInitializerError(message);

    }

    private List<Transfer> applyFilterInterval(long initial, long finals, List<Transfer> t){
        
        List<Transfer> itemForDelete = new ArrayList<Transfer>();
        
        if(initial > 0 && finals > 0){
            for(Transfer item : t) {
                if (LocalDateTimeToLong.of(item.getTransferDate()) < initial || LocalDateTimeToLong.of(item.getTransferDate()) > finals) {
                    itemForDelete.add(item);
                }
            }
        } else if(initial > 0){
            for(Transfer item : t) {
                if (LocalDateTimeToLong.of(item.getTransferDate()) < initial) {
                    itemForDelete.add(item);
                }
            }
        } else if(finals > 0){
            for(Transfer item : t) {
                if (LocalDateTimeToLong.of(item.getTransferDate()) > finals) {
                    itemForDelete.add(item);
                }
            }
        }
        t.removeAll(itemForDelete);
        
        return t;
    }

}
