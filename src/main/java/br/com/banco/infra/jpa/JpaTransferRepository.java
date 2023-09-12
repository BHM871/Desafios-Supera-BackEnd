package br.com.banco.infra.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.core.domain.Transfer;

public interface JpaTransferRepository extends JpaRepository<Transfer, Long> {
    
    public List<Transfer> findByOperatorName(String operatorName);

}
