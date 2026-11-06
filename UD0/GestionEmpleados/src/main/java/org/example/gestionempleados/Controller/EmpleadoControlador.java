package org.example.gestionempleados.Controller;

import org.example.gestionempleados.Service.EmpleadoServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleados")
public class EmpleadoControlador {
    private EmpleadoServicio servicio;

    public EmpleadoControlador(EmpleadoServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping()

    public String mostrarEmpleados(Model model){
        model.addAttribute("lista", servicio.obtenerEmpleados());
        return "index";
    }
}
