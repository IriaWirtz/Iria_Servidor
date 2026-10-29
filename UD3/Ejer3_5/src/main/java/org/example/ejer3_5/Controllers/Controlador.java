package org.example.ejer3_5.Controllers;

import org.example.ejer3_5.Modelo.Inscripcion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Controlador {
    private List<Inscripcion> listado = new ArrayList<>();
    private Long idActual = 1L;
    @GetMapping("/")
    public String mostrarIndex(Model model){
        model.addAttribute("listado", listado );
        return "inscripciones";
    }
    @GetMapping("/inscripciones/nueva")
    public String nueva(Model model) {
        model.addAttribute("inscripcion", new Inscripcion());
        return "formulario";
    }

    @PostMapping("/inscripciones")
    public String guardar(
            @ModelAttribute Inscripcion inscripcion) {

        inscripcion.setId(idActual);
        idActual++;

        listado.add(inscripcion);

        return "redirect:/inscripciones";
    }
}

