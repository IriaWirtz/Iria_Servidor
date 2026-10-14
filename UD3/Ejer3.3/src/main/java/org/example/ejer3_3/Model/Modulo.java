package org.example.ejer3_3.Model;

public class Modulo {
    private int id, horas;
    private String nombre;
    private Integer curso;

    public Modulo(int id, Integer curso, int horas, String nombre) {
        this.id = id;
        this.curso = curso;
        this.horas = horas;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
