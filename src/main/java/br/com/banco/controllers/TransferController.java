package br.com.banco.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.models.TransferModel;
import br.com.banco.repositories.TransferRepository;

import java.util.*;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class TransferController {
    
    @Autowired
    TransferRepository transferRepository;

    @GetMapping("/tranfers")
    public ResponseEntity<List<TransferModel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(transferRepository.findAll());
    }

    @GetMapping("/transfers/{intial}&{finals}&{name}")
    public ResponseEntity<List<TransferModel>> getWithFilter(
        @PathParam(value = "initial") long initial,
        @PathParam(value = "finals") long finals, 
        @PathParam(value = "name") String name
    ) {
        List<TransferModel> transfers = applayFilters(initial, finals, name, transferRepository.findAll());

        return ResponseEntity.status(HttpStatus.OK).body(transfers);
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
