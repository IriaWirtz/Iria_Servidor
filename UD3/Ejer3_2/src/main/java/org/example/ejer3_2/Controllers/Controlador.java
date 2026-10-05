package org.example.ejer3_2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Controlador {

    private List<Integer> nums = new ArrayList<>();

    public Controlador() {
       inicializarLista();
    }

    @GetMapping("/lista")
    public String paginaInicio(Model model){
        model.addAttribute("nums", nums);
        return "lista";
    }

    private void inicializarLista(){
        for (int i = 0; i < Math.random()*50+1;i++ ) {
            nums.add((int) (Math.random() * 100) +1);
        }

    }




}
