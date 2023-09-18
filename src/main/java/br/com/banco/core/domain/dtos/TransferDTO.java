
package br.com.banco.core.domain.dtos;

import java.math.BigDecimal;

import br.com.banco.core.domain.TransferType;
import lombok.*;

@Getter
@AllArgsConstructor
public class TransferDTO {

    private final BigDecimal tValue;
    private final TransferType tType;
    private final String operatorName;
    private Integer accountId;
    
}