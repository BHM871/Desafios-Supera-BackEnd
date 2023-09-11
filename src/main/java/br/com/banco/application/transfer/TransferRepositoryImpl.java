package br.com.banco.application.transfer;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.banco.core.domain.TransferModel;
import br.com.banco.core.usecases.transfers.TransferRepository;
import br.com.banco.infra.jpa.JpaTransferRepository;

@Repository
public class TransferRepositoryImpl implements TransferRepository  {

    @Autowired
    private JpaTransferRepository repository;

    @Override
    public TransferModel create(TransferModel transfer){
        return repository.save(transfer);
    }

    @Override
    public List<TransferModel> findAll() {
        return repository.findAll();
    }

    @Override
    public List<TransferModel> findByOperatorName(String operatorName) {
        return repository.findByOperatorName(operatorName);
    }
    
    @Override
    public List<TransferModel> findInInterval(long initial, long finals){
        
        List<TransferModel> transfers = findAll();

        transfers = applyFilterInterval(initial, finals, transfers);
        
        return transfers;
    }

    @Override
    public List<TransferModel> findByOperatorNameAndInterval(String operatorName, long initial, long finals){

        List<TransferModel> transfers = findByOperatorName(operatorName);

        transfers = applyFilterInterval(initial, finals, transfers);

        return transfers;
    }

    private List<TransferModel> applyFilterInterval(long initial, long finals, List<TransferModel> t){
        
        List<TransferModel> itemForDelete = new ArrayList<TransferModel>();
        
        if(initial > 0 && finals > 0){
            for(TransferModel item : t) {
                if (item.getTransferDate().getLong(ChronoField.NANO_OF_SECOND) < initial || item.getTransferDate().getLong(ChronoField.NANO_OF_SECOND) > finals) {
                    itemForDelete.add(item);
                }
            }
        } else if(initial > 0){
            for(TransferModel item : t) {
                if (item.getTransferDate().getLong(ChronoField.NANO_OF_SECOND) < initial) {
                    itemForDelete.add(item);
                }
            }
        } else if(finals > 0){
            for(TransferModel item : t) {
                if (item.getTransferDate().getLong(ChronoField.NANO_OF_SECOND) > finals) {
                    itemForDelete.add(item);
                }
            }
        }
        t.removeAll(itemForDelete);
        
        return t;
    }

}
