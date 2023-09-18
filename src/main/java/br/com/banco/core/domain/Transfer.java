package br.com.banco.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import br.com.banco.core.domain.dtos.TransferDTO;
import lombok.*;

/*
Para a crição do model segui e acordo com o arquivo de database disponibilizado.

Eu não relacionei as tabelas pois, quando era feito a API retornava uma cascata infinita.

transferencia{
    conta{
        [
            transferencia{
                conta{
                    [
                        transferencia...
                    ]
                }
            }
        ]
    }
}

Desta forma optei por salvar apenas uma referencia para a tabela de conta

Optei por retirar os métodos setters.
Pois este projeto não como objetivo mudar nenhum valor, apenas ler
*/

@Entity
@Table(name = "TB_TRANSFER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transfer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime transferDate;

    private BigDecimal tValue;

    @Enumerated(EnumType.STRING)
    private TransferType tType;

    private String operatorName;

    @ManyToOne(optional = true, cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = true)  
    private Account account;

    public Transfer(TransferDTO data) {
        this.tValue = data.getTValue();
        this.tType = data.getTType();
        this.operatorName = data.getOperatorName();
    }

}