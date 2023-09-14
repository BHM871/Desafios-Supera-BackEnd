package br.com.banco.core.domain.dtos;

public class TransferByAccountDTO {
    
    private final Integer id;

    public TransferByAccountDTO(Integer id){
        this.id = id;
    }

    public TransferByAccountDTO(){
        this.id = null;
    }

    public Integer getId() {
        return id;
    }

}
