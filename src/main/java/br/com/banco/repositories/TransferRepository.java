package br.com.banco.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository<T, ID> extends JpaRepository<T, ID> {

    public List<T> findByOperatorName(String operatorName);
    
    public List<T> findInInterval(long initial, long finals);

    public List<T> findByOperatorNameAndInterval(String operatorName, long initial, long finals);
    
}
