package org.example.huerto.Service;

import org.example.huerto.Exception.ValidationException;
import org.example.huerto.Model.Planta;
import org.example.huerto.Repository.RepositorioPlanta;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlantaService {
    RepositorioPlanta plantaRepositorio;

    public PlantaService (RepositorioPlanta repositorio){
        this.plantaRepositorio = repositorio;
    }
    

    public List<Planta> obtenerPlantas(){
    return plantaRepositorio.findAll();
    }

    public Planta save(Planta planta){
        if(validarNopmbre(planta)) {
            return plantaRepositorio.save(planta);
        }
        else return null;
    }

    public Planta cosechar(Long id){
      return plantaRepositorio.cosechar(id);
    }

    public boolean validarNopmbre(Planta planta){
        if(plantaRepositorio.findByName(planta.getNombre()) != null ){
            //ya existe una planta con ese nombre, devuelve excepcion
            throw new ValidationException("El nombre no puede estar repetido");
        }
        //si no existe, devuelve true;
        else return true;

    }


}
