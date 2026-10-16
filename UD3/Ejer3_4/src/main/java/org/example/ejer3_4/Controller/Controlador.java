package org.example.ejer3_4.Controller;

import org.example.ejer3_4.Model.Modulo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class Controlador {
    private List<Modulo> lista = new ArrayList<>();

    public Controlador() {
        inicializarModulo();
    }

    @GetMapping("/modeloVista")
    public String mostrarModelo( Model model, @RequestParam(required = false) Integer curso){
        model.addAttribute("modulos", filtrarPorModulo(curso));
        return "modeloVista";
    }

    @GetMapping("/modeloVista/{id}")

    public String mostrarDetalles(@PathVariable Integer id, Model model){
        for(Modulo m : lista){
            if(m.getId() == id){
                model.addAttribute("modulo", m);
                return "detalles";
            }
        }
        return "detalles-no-encontrado";
    }

    private List<Modulo> filtrarPorModulo(Integer curso){
        return lista.stream().filter(x -> Objects.equals(curso, x.getCurso())|| curso == null).collect(Collectors.toList());
    }

    private void inicializarModulo(){
        lista.add(new Modulo(1, 1, 12, "Digitalización"));
        lista.add(new Modulo(2, 2, 24, "Programación"));
        lista.add(new Modulo(3, 1, 50, "BBDD"));
        lista.add(new Modulo(4, 2, 80, "Contornos"));
        lista.add(new Modulo(5, 1, 150, "Sostibilidad"));
        lista.add(new Modulo(6, 1, 200, "Lenguaje de Marcas"));


    }

}
