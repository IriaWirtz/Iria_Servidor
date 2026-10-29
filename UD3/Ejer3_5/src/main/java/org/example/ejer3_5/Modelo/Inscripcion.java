package org.example.ejer3_5.Modelo;

public class Inscripcion {
    private String nombre, correo, comentarios;
    private Boolean turno, aceptaNormas;
    private Long id;

    public Inscripcion(Long id, String nombre, String correo, String comentarios, Boolean turno, Boolean aceptaNormas) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.comentarios = comentarios;
        this.turno = turno;
        this.aceptaNormas = aceptaNormas;
    }

    public Inscripcion() {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Boolean getTurno() {
        return turno;
    }

    public void setTurno(Boolean turno) {
        this.turno = turno;
    }

    public Boolean getAceptaNormas() {
        return aceptaNormas;
    }

    public void setAceptaNormas(Boolean aceptaNormas) {
        this.aceptaNormas = aceptaNormas;
    }
}
