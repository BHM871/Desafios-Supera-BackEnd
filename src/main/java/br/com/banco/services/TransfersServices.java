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

    //Busca todas as tranferências
    public List<TransferModel> findAll(){
        return transferRepository.findAll();
    }

    //Busca todas as tranferências, aplica os filtros, por fim retorna a lista filtrada
    public List<TransferModel> findWithFilter(long initial, long finals,  String name){
        List<TransferModel> transfers;

        transfers = name.isEmpty() ? 
            transferRepository.findAll() : 
            transferRepository.findByOperatorName(name);

        transfers = applayFiltersInverval(initial, finals, transfers);

        return transfers;
    }

    //Aplica o filtro de INTERVALO na lista de transferências e retorna a lista filtrada
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

}
