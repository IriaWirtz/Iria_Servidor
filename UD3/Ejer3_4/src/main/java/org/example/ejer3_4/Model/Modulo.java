package org.example.ejer3_4.Model;

public class Modulo {
    private int horas;
    private String nombre;
    private Integer curso, id;

    public Modulo(Integer id, Integer curso, int horas, String nombre) {
        this.id = id;
        this.curso = curso;
        this.horas = horas;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
