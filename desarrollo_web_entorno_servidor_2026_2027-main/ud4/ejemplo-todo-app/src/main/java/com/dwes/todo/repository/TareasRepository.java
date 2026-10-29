package com.dwes.todo.repository;

import com.dwes.todo.model.Tarea;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TareasRepository {
    private final List<Tarea> tareas = new ArrayList<>();
    private long ultimoId = 0;

    public List<Tarea> findAll(){
        return tareas;
    }

    public Tarea findById(Long id){
        for(Tarea tarea:tareas){
            if(Objects.equals(tarea.getId(), id)){
                return tarea;
            }
        }
        return null;
    }

    public Tarea save(Tarea tarea){
        if(tarea.getId() == null){
            tarea.setId(++ultimoId);
            tareas.add(tarea);
            return tarea;
        }
       for (int i = 0; i < tareas.size(); i++){
           if(tareas.get(i).getId().equals(tarea.getId())){
               tareas.set(i, tarea);
               return tarea;
           }
       }

       tareas.add(tarea);
       return tarea;


    }

    public void deleteById(Long id){
        Tarea tarea = findById(id);

        if(tarea != null){
            tareas.remove(tarea);
        }
    }
}
