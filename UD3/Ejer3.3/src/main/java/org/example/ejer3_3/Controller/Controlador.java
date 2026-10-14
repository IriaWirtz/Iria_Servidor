package org.example.ejer3_3.Controller;

import org.example.ejer3_3.Model.Modulo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/")
    public String mostrarModelo(@RequestParam(required = false)Integer curso, Model model){
        model.addAttribute("modulos", lista);
        return "modeloVista";
    }

    private List<Modulo> filtrarPorModulo(Integer curso){
        return lista.stream().filter(x -> Objects.equals(curso, x.getCurso())).collect(Collectors.toList());
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
