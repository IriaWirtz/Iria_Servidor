package org.example.biblioteca3.Repository;

import org.example.biblioteca3.Model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Repositorio {
    List<Libro> biblioteca = new ArrayList<>();
    private long ultimoId = 0;

    public List<Libro> findAll(){
        return biblioteca;
    }
}
