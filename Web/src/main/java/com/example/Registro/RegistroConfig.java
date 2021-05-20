package com.example.Registro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration
public class RegistroConfig {
    @Bean
    CommandLineRunner commandLineRunner(RegistroRepository repository){
        return args -> {
            Registro David = new Registro(
                    "David", "Rueda", "davidrc56@gmail.com", LocalDate.of(1994, Month.APRIL, 1)
            );
            Registro Andrea = new Registro(
                    "Andres", "Perea", "andres123@gmail.com", LocalDate.of(1995, Month.JANUARY, 23)
            );
            repository.saveAll(List.of(David, Andrea));
        };
    }

}
