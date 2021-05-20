package com.example.Registro;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Registro {
    @Id
    @SequenceGenerator(
            name = "registro_sequence",
            sequenceName = "registro_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "registro_sequence"
    )
    private Long id;
    private String nombre;  
    private String apellido;
    private String email;
    private LocalDate fecha;
    @Transient
    private Integer edad;

    public Registro(String nombre, String apellido, String email, LocalDate fecha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fecha = fecha;
    }

    public Registro() {
    }

    public Registro(Long id, String nombre, String apellido, String email, LocalDate fecha) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Integer getEdad() {
        return Period.between(this.fecha,LocalDate.now()).getYears();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", fecha=" + fecha +
                ", edad=" + edad +
                '}';
    }
}
