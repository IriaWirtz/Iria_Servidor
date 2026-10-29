package org.example.biblioteca3.Controller;

import org.example.biblioteca3.Model.Libro;
import org.example.biblioteca3.Repository.Repositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class Controlador {
    List<Libro> biblioteca = new ArrayList<>();
    private Repositorio librosRepo;

    public Controlador() {
        inicializarBiblio();
    }

    private void inicializarBiblio(){
        biblioteca.add(new Libro(0, 180, "Indigno de ser humano", "Osamu Dazai", false));
        biblioteca.add(new Libro(1, 300, "HxH", "Togashi", true));
        biblioteca.add(new Libro(2, 500, "El Quijote", "Daniel Vázquez Cervantes", true));
        biblioteca.add(new Libro(3, 350, "Los juegos del hambre" ,"Héctor Pallas", false));
    }

    @GetMapping({ "/","/index"})
    public String mostrarVista(Model model, @RequestParam(required = false) Boolean prestado) {
        model.addAttribute("biblioteca", filtrarLibros(prestado));
        return "index";
    }

    @GetMapping("/index/{id}")
    public String mostrarDetalles(@PathVariable Long id, Model model){


        model.addAttribute("biblioteca", biblioteca);
        return "detalles";
    }

    private List<Libro> filtrarLibros(Boolean prestado){
        return biblioteca.stream().filter(x -> prestado == x.isPrestado() || prestado == null).collect(Collectors.toList());
    }

    @PostMapping("/biblioteca/toggle/{id}")

    public String cambiarEstado(@PathVariable long id){
        for (int i = 0; i < biblioteca.size(); i++) {
            if (biblioteca.get(i).getId() == id) {
                Libro l1 = biblioteca.get(i);
                l1.setPrestado(!l1.isPrestado());
                biblioteca.set(i, l1);
                return "redirect:/index";
            }
        }
        return "redirect:/libro-no-encontrado";
    }


}
