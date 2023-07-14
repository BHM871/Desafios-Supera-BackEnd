package br.com.banco.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.models.TransferModel;

@Repository
public interface TransferRepository extends JpaRepository<TransferModel, UUID>  {
    
}
