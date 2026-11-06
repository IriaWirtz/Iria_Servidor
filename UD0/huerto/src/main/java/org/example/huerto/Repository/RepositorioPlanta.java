package org.example.huerto.Repository;

import org.example.huerto.Model.Planta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Repository
public class RepositorioPlanta {
    private List<Planta>  lista = new ArrayList<>();
    private Long ultimoId=0L;

    public List<Planta> findAll(){
        return lista;
    }

    public Planta findById(Long id){
        return lista.stream()
                .filter
                (planta -> planta.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Planta findByName(String nombre){
        for(Planta planta : lista){
            if(planta.getNombre().equals(nombre)){
                return planta;
            }
        }
        return null;
    }

    public Planta save(Planta planta){
        if(planta.getId() == null){
            planta.setId(ultimoId);
            ultimoId++;
            lista.add(planta);
            return planta;
        }

        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getId().equals(planta.getId())){
                lista.set(i, planta);
                return planta;
            }

        }
        lista.add(planta);
        return planta;

    }

    public Planta cosechar(Long id){
        for (int i = 0; i < lista.size(); i++) {
            if(id.equals(lista.get(i).getId())){
                lista.get(i).setEjemplares(lista.get(i).getEjemplares()-1);
                return lista.get(i);
            }

        }
        return null;
    }

    public Planta delete(Planta planta){
        for (Planta plant : lista){
            if(Objects.equals(plant.getId(), planta.getId())){
                lista.remove(plant);
                return plant;
            }
        }
        return null;

    }

}
