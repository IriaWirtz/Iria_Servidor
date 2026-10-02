package org.example.ejer2_7.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController{
        @GetMapping("/acerca")
        public String mostrarAcerca() {
            return "acerca";
        }
    @GetMapping("/")
    public String mostrarIndex() {
        return "index";
    }
    @GetMapping("/destacados")
    public String mostrarDestacados() {
        return "destacados";
    }
    @GetMapping("/galeria")
    public String mostrarGaleria() {
        return "galeria";
    }
    }

