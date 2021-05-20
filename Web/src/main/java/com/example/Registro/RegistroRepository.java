package com.example.Registro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
    //SELECT * FROM registro WHERE email = ?
    Optional<Registro> findRegistroByEmail(String Email);
}
