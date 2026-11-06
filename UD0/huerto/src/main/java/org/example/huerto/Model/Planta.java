package org.example.huerto.Model;

public class Planta {
    private Long id;
    private String nombre;
    private int ejemplares;

    public Planta() {
    }

    public Planta(Long id, String nombre, int ejemplares) {
        this.id = id;
        this.nombre = nombre;
        this.ejemplares = ejemplares;
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

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }
}
