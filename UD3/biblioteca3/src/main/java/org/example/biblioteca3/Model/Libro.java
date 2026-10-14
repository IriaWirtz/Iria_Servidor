package org.example.biblioteca3.Model;

public class Libro {
    private int id, numPag;
    private String titulo, autor;
    private Boolean prestado;

    public Libro(int id, int numPag, String titulo, String autor, Boolean prestado) {
        this.id = id;
        this.numPag = numPag;
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = prestado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(Boolean prestado) {
        this.prestado = prestado;
    }
}
