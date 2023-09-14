package br.com.banco.infra.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.core.domain.Account;

public interface JpaAccountRepository extends JpaRepository<Account, Integer> {
    
    public Optional<Account> findById(Integer id);

    public Optional<Account> findByNameResponsible(String nameResponsible);

}
