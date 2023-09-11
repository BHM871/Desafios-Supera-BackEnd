package br.com.banco.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.banco.models.TransferModel;

@Repository
public abstract class TransferRepositoryImpl implements TransferRepository<TransferModel, Integer>  {
    
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
                if (item.getTransferDate().getTime() < initial || item.getTransferDate().getTime() > finals) {
                    itemForDelete.add(item);
                }
            }
        } else if(initial > 0){
            for(TransferModel item : t) {
                if (item.getTransferDate().getTime() < initial) {
                    itemForDelete.add(item);
                }
            }
        } else if(finals > 0){
            for(TransferModel item : t) {
                if (item.getTransferDate().getTime() > finals) {
                    itemForDelete.add(item);
                }
            }
        }
        t.removeAll(itemForDelete);
        
        return t;
    }

}
