package br.com.banco.core.domain;

import java.io.Serializable;

import javax.persistence.*;

import br.com.banco.core.domain.dtos.NewAccountDTO;
import lombok.*;

@Entity
@Table(name = "TB_ACCOUNT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nameResponsible;

    public Account(NewAccountDTO data) {
        this.nameResponsible = data.getNameResponsible();
    }
    
}