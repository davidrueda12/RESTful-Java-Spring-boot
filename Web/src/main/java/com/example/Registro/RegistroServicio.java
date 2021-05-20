package com.example.Registro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RegistroServicio {

    private final RegistroRepository registroRepository;

    @Autowired
    public RegistroServicio(RegistroRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    public List<Registro> getRegistro(){
        return registroRepository.findAll();
    }

    public void addNewRegistro(Registro registro) {

        Optional<Registro> registroByEmail = registroRepository.findRegistroByEmail(registro.getEmail());
        if (registroByEmail.isPresent()){
            throw new IllegalStateException("el email ya esta registrado");
        }
        registroRepository.save(registro);
        System.out.println(registro);
    }

    public void borrarRegistro(Long registroId) {
        boolean comprobar = registroRepository.existsById(registroId);
            if(!comprobar){
                throw new IllegalStateException("El registro "+registroId+" no existe");
            }
        registroRepository.deleteById(registroId);
    }
    @Transactional
    public void modificarRegistro(Long registoId, String nombre, String email) {
        Registro registro = registroRepository.findById(registoId).orElseThrow(() -> new IllegalStateException("El registro con id "+registoId+" no existe"));

        if(nombre != null && nombre.length()>0 && !Objects.equals(registro.getNombre(),nombre)) {
            registro.setNombre(nombre);
        }
        if (email != null && email.length()>0 && !Objects.equals(registro.getEmail(),email)) {
            Optional<Registro> registroOptional = registroRepository.findRegistroByEmail(email);
            if (registroOptional.isPresent()) {
                throw new IllegalStateException("el email ya esta registrado");
            }
            registro.setEmail(email);
        }
    }
}
