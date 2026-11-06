package org.example.gestionempleados.Service;

import org.example.gestionempleados.Model.Empleado;
import org.example.gestionempleados.Repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio {
    private EmpleadoRepository repositorioEmpleado;

    public EmpleadoServicio(EmpleadoRepository repositorioEmpleado) {
        this.repositorioEmpleado = repositorioEmpleado;
    }

    public List<Empleado> obtenerEmpleados(){
        return repositorioEmpleado.findAll();
    }

    public Empleado crearEmpleado(Empleado empleado){
        if(validarEmpleado(empleado) && repositorioEmpleado.findByEmail(empleado.getEmail()) == null)
        return repositorioEmpleado.save(empleado);

        else return null;
    }

    public Empleado borrarEmpleado(Empleado empleado){
        return repositorioEmpleado.delete(empleado);
    }

    public Empleado editarEmpleado(Empleado empleado){
        if(validarEmpleado(empleado) && repositorioEmpleado.findByEmail(empleado.getEmail()) == null ||repositorioEmpleado.findByEmail(empleado.getEmail()).getId().equals(empleado.getId())){
            repositorioEmpleado.save(empleado);
            return empleado;
        }
        else return null;
    }

    public boolean validarEmpleado(Empleado empleado){
        if(empleado.getSalario() < 18000 ){
            return false;
        }
        else return true;
    }
}
