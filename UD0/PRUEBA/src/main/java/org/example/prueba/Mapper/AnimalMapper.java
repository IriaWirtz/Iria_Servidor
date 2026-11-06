package org.example.prueba.Mapper;

import org.example.prueba.DTO.AnimalDTO;
import org.example.prueba.Model.Animal;

public class AnimalMapper {
    public static AnimalDTO toAnimalDTO(Animal animal){
        return new AnimalDTO(animal.getId(), animal.getNombre());
    }

    public static Animal toAnimal(AnimalDTO animalDTO){
        return new Animal(animalDTO.getId(), animalDTO.getNombre());
    }
}
