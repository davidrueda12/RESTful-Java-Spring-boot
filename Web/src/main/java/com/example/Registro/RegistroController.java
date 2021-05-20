package com.example.Registro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController

@RequestMapping(path = "api/registro")
public class RegistroController {

    private final RegistroServicio registroServicio;

    @Autowired
    public RegistroController(RegistroServicio registroServicio) {
        this.registroServicio = registroServicio;
    }

    @GetMapping
    public List<Registro> getRegistro(){
        return registroServicio.getRegistro();
    }

    @PostMapping
    public void registroNewRegistro(@RequestBody Registro registro){
        registroServicio.addNewRegistro(registro);
    }

    @DeleteMapping(path = "{registroId}")
    public void borrarRegistro(@PathVariable("registroId")Long registroId){
        registroServicio.borrarRegistro(registroId);
    }

    @PutMapping(path = "{registroId}")
    public void modificarRegistro(@PathVariable("registroId")Long registoId,@RequestParam(required = false)String nombre,
                                  @RequestParam(required = false)String email){
        registroServicio.modificarRegistro(registoId,nombre,email);
    }
}

