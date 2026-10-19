package org.example.ejer3_5.Modelo;

public class Inscripcion {
    private String nombre, correo, comentarios;
    private Boolean turno, aceptaNormas;

    public Inscripcion(String nombre, String correo, String comentarios, Boolean turno, Boolean aceptaNormas) {
        this.nombre = nombre;
        this.correo = correo;
        this.comentarios = comentarios;
        this.turno = turno;
        this.aceptaNormas = aceptaNormas;
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
