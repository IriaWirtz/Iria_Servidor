package org.example.prueba.Model;

import jakarta.validation.constraints.NotBlank;

public class Animal {
    private Long id;

    //para que el nombre no pueda estar en blanco
    @NotBlank(message="El nombre no puede estar vacío")
    private String nombre;

    public Animal(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Animal() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
