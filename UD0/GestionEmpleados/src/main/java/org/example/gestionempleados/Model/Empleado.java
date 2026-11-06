package org.example.gestionempleados.Model;

public class Empleado {
    private Long id;
    private String nombre;
    private String email;
    private Double salario;


    public Empleado() {
    }

    public Empleado(Long id, String nombre, String email, Double salario) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.salario = salario;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
