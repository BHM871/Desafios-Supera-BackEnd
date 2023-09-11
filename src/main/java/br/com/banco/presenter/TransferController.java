package br.com.banco.presenter;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.core.domain.TransferModel;

@RestController
public interface TransferController {
    
    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<List<TransferModel>> getAll();

    @CrossOrigin
    @GetMapping("/filters")
    public ResponseEntity<List<TransferModel>> getWithFilter(
        @RequestParam(value = "initial", required = false, defaultValue = "0") String i,
        @RequestParam(value = "final", required = false, defaultValue = "0") String f, 
        @RequestParam(value = "name", required = false, defaultValue = "") String name
    );
    
}
