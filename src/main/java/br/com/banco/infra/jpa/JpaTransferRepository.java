package br.com.banco.infra.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.core.domain.Account;
import br.com.banco.core.domain.Transfer;
import java.time.LocalDateTime;


public interface JpaTransferRepository extends JpaRepository<Transfer, Long> {

    public Optional<Transfer> findById(Long id);
    
    public List<Transfer> findByOperatorName(String operatorName);

    public List<Transfer> findByTransferDateBetween(LocalDateTime start, LocalDateTime end);

    public List<Transfer> findByOperatorNameAndTransferDateBetween(String operatorName, LocalDateTime start, LocalDateTime end);

    public List<Transfer> findByAccount(Account account);

}
