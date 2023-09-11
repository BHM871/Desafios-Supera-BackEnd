package br.com.banco.application.transfer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.banco.core.domain.TransferModel;
import br.com.banco.core.domain.dto.TransferDTO;
import br.com.banco.presenter.TransferController;
import br.com.banco.presenter.TransferServices;

@Component
public class TransferControllerImpl implements TransferController {
    
    @Autowired
    TransferServices transferServices;

    @Override
    public ResponseEntity<TransferModel> createTransfer(@RequestBody TransferDTO transfer){
        return ResponseEntity.status(HttpStatus.CREATED).body(transferServices.create(transfer));
    }

    //Método para buscar todas as transferências
    @Override
    public ResponseEntity<List<TransferModel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(transferServices.findAll());
    }

    //Método para filtrar a busca pelas transferências
    @Override
    public ResponseEntity<List<TransferModel>> getWithFilter(
        @RequestParam(value = "initial", required = false, defaultValue = "0") String i,
        @RequestParam(value = "final", required = false, defaultValue = "0") String f, 
        @RequestParam(value = "name", required = false, defaultValue = "") String name
    ) 
        long initial = Long.valueOf(i);
        long finals = Long.valueOf(f);
        return ResponseEntity.status(HttpStatus.OK).header("TransferHeader").body(transferServices.findWithFilter(initial, finals, name));
    }
    
}
