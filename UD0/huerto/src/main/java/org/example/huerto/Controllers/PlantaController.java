package org.example.huerto.Controllers;

import org.example.huerto.Exception.ValidationException;
import org.example.huerto.Model.Planta;
import org.example.huerto.Service.PlantaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/planta")
public class PlantaController {
    private PlantaService servicio ;

    public PlantaController(PlantaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping()
    public String mostrarLista (Model model){
        model.addAttribute("lista", servicio.obtenerPlantas());
        return "index";
    }

    @GetMapping("/nueva")

    public String mostrarNueva(Model model){
        model.addAttribute("planta", new Planta());
        return "nueva";
    }

    @PostMapping("/{id}/cosechar")

    public String cosechar(@PathVariable("id") Long id, Model model){
        servicio.cosechar(id);
        model.addAttribute("lista", servicio.obtenerPlantas());
        return "redirect:/planta";

    }

    @PostMapping("/nueva")

    public String crearPlanta(@ModelAttribute("nuevaPlanta")Planta nuevaPlanta, Model model, RedirectAttributes flash, BindingResult error){
        try {
            servicio.save(nuevaPlanta);
            model.addAttribute("lista", servicio.obtenerPlantas());
            flash.addFlashAttribute("mensaje", "Se ha creado la planta: " + nuevaPlanta.getNombre()
                    + " con ID: " + nuevaPlanta.getId() + " y ejemplares: " + nuevaPlanta.getEjemplares());
            return "redirect:/planta";
        } catch (ValidationException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("lista", servicio.obtenerPlantas());
            return "index";

        }
    }
}
