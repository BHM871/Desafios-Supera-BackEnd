package br.com.banco.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "TB_ACCOUNT")
public class AccountModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idConta;
    private String nomeResponsavel;

    
}
