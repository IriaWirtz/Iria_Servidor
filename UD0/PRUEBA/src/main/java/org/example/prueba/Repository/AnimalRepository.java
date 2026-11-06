package org.example.prueba.Repository;

import org.example.prueba.Model.Animal;

import java.util.List;

public interface AnimalRepository {
    public List<Animal> findAll();
    public Animal save(Animal nuevo);
    public Animal findById(Long id);
    public Animal findByName(String nombre);
}
