package br.com.banco.commun;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

//Classe pare converter o objeto "LocalDateTime" para o tipo "long"
public final class LocalDateTimeConv {
    
    public static long toLong(LocalDateTime localDateTime){
        if(localDateTime == null) return 0;
        
        ZonedDateTime zdt = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        return zdt.toInstant().toEpochMilli();
    }

}
