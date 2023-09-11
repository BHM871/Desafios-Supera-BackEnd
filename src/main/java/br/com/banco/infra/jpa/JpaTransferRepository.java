package br.com.banco.infra.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.core.domain.TransferModel;

public interface JpaTransferRepository extends JpaRepository<TransferModel, Integer> {
    
    public List<TransferModel> findByOperatorName(String operatorName);

}
