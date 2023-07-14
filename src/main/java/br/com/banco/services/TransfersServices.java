package br.com.banco.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.banco.models.TransferModel;
import br.com.banco.repositories.TransferRepository;

@Transactional
public class TransfersServices {
    
    @Autowired
    TransferRepository transferRepository;

    public List<TransferModel> findAll(){
        return transferRepository.findAll();
    }

    public List<TransferModel> findWithFilter(long initial, long finals,  String name){
        List<TransferModel> transfers = applayFilters(initial, finals, name, transferRepository.findAll());
        return transfers;
    }

    private static List<TransferModel> applayFilters(long initial, long finals, String name, List<TransferModel> t){
        List<TransferModel> transfers = t;

        if(initial > 0 && finals > 0){
            List<TransferModel> itemForDelete = new ArrayList<TransferModel>();

            for(TransferModel item : transfers) {
                if (item.getTransferDate().getTime() < initial || item.getTransferDate().getTime() > finals) {
                    transfers.remove(item);
                }
            }

            transfers.removeAll(itemForDelete);
        }

        if(!name.isEmpty()){
            List<TransferModel> itemForDelete = new ArrayList<TransferModel>();
            
            for(TransferModel item : transfers) {
                if (item.getOperatorName() != name) {
                    itemForDelete.add(item);
                }
            }

            transfers.removeAll(itemForDelete);
        }

        return transfers;
    }

}
