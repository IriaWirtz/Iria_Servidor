package org.example.ejer3_5.Controllers;

import org.example.ejer3_5.Modelo.Inscripcion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Controlador {
    private List<Inscripcion> listado = new ArrayList<>();

    @GetMapping("/index")
    public String mostrarIndex(){
        return "index";
    }
}
