package org.example.prueba.DTO;

import jakarta.validation.constraints.NotBlank;

public class AnimalDTO {
    private Long id;

    //para que el nombre no pueda estar en blanco
    @NotBlank(message="El nombre no puede estar vacío")
    private String nombre;

    public AnimalDTO() {
    }

    public AnimalDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
