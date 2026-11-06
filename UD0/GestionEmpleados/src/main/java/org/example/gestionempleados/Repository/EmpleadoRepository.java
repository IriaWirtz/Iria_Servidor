package org.example.gestionempleados.Repository;

import org.example.gestionempleados.Model.Empleado;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class EmpleadoRepository {
    private List<Empleado> listaEmpleados;
    private Long ultimoId = 0L;

    public List<Empleado> findAll(){
        return listaEmpleados;
    }

    public Empleado findByID(Long id){
        return listaEmpleados.stream().
                filter(empleado -> Objects.equals(empleado.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public Empleado findByEmail(String email){
        return listaEmpleados.stream()
                .filter(empleado -> empleado.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Empleado save(Empleado empleado){
        if(empleado.getId() == null){
            empleado.setId(++ultimoId);
            listaEmpleados.add(empleado);
            return empleado;
        }

        for (int i = 0; i < listaEmpleados.size(); i++) {
            if(Objects.equals(empleado.getId(), listaEmpleados.get(i).getId())){
                listaEmpleados.set(i, empleado);
                return empleado;
            }

        }

        listaEmpleados.add(empleado);
        return empleado;



    }

    public Empleado delete(Empleado empleado){
        for (Empleado e : listaEmpleados){
            if(e.getId().equals(empleado.getId())){
                listaEmpleados.remove(e);
                return e;
            }
        }

    return null;
    }
}
