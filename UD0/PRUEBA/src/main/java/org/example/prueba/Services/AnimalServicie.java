package org.example.prueba.Services;

import org.example.prueba.DTO.AnimalDTO;
import org.example.prueba.Exception.ValidarDatosExcepcion;
import org.example.prueba.Mapper.AnimalMapper;
import org.example.prueba.Model.Animal;
import org.example.prueba.Repository.AnimalRepository;
import org.example.prueba.Repository.AnimalRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServicie {
    AnimalRepositoryImpl repositorio;



    public AnimalServicie(AnimalRepositoryImpl repositorio) {
        this.repositorio = repositorio;
    }
    //obtener todos los animales
    public List<AnimalDTO> obtenerAnimales(){
        List<Animal> animalList = repositorio.findAll();

    }


    //creamos el animal si su nombre no esta en la BBDD
    public AnimalDTO crearAnimal(AnimalDTO nuevoAnimalDTO){
        Animal nuevoAnimal = AnimalMapper.toAnimal(nuevoAnimalDTO);
        if(validarNombre(nuevoAnimal)) {
            Animal animal = repositorio.save(nuevoAnimal);
            return AnimalMapper.toAnimalDTO(animal);

        }
        else return null;

    }


    //comprobar que no se repite el nombre
    private boolean validarNombre(Animal animal){
        Animal validarAnimal = repositorio.findByName(animal.getNombre());
        if(validarAnimal == null){

            // si no existe un animal con ese nombre devuelve true
            return true;
        }
        //si sí que existe, salta excepción
        else throw new ValidarDatosExcepcion("Nombre repetido");
    }


}
