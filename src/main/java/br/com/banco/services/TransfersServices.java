package br.com.banco.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.models.TransferModel;
import br.com.banco.repositories.TransferRepository;

@Service
public class TransfersServices {
    
    @Autowired
    TransferRepository transferRepository;

    public List<TransferModel> findAll(){
        List<TransferModel> a = transferRepository.findAll();
        return a;
    }

    public List<TransferModel> findWithFilter(long initial, long finals,  String name){
        List<TransferModel> transfers = transferRepository.findAll();

        transfers = applayFiltersInverval(initial, finals, transfers);
        transfers = applayFiltersName(name, transfers);

        return transfers;
    }

    private List<TransferModel> applayFiltersInverval(long initial, long finals, List<TransferModel> t){

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

    private List<TransferModel> applayFiltersName(String name, List<TransferModel> t){

        List<TransferModel> itemForDelete = new ArrayList<TransferModel>();
        if(!name.isEmpty()){
            for(TransferModel item : t) {
                if(item.getOperatorName() == null || (item.getOperatorName() != null && !item.getOperatorName().equals(name))){
                    itemForDelete.add(item);
                } 
            }
        }
        t.removeAll(itemForDelete);

        return t;
    }

}
