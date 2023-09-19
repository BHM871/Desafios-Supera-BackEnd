package br.com.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
    title = "Search Transfer API", 
    version = "1", 
    description = "Simple API for manage transfers",
    contact = @Contact(name = "Adrian Almeida - BHM Code", email = "adrianalmeida@gmail.com")
    )
)
public class BancoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BancoApplication.class, args);
    }

}