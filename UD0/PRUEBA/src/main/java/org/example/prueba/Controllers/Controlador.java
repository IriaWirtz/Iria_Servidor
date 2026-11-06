package org.example.prueba.Controllers;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.example.prueba.DTO.AnimalDTO;
import org.example.prueba.Exception.ValidarDatosExcepcion;
import org.example.prueba.Model.Animal;
import org.example.prueba.Services.AnimalServicie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

//todo lo que entre por este controlador empieza por /animal
@RequestMapping("/animal")
public class Controlador {
    AnimalServicie animalService;

        //inyectamos el servicio por constructor
    public Controlador(AnimalServicie animalService) {
        this.animalService = animalService;
    }

    //pasamos informacion a la vista mediante el model
    // va a mostrar el listado de animales
    //y un formulario para crear nuevos animales
    @GetMapping()
    public String mostrarAnimales(Model model){
        //pasamos el listado de animales
    model.addAttribute("lista", animalService.obtenerAnimales());
        //preparamos el objeto del formulario
    model.addAttribute("nuevoAnimal", new Animal());
        //devolvemos la vista
    return "index";

    }

    //recibimos los datos del formulario
    //@Valid aplica las validaciones de la clase Animal sobre lo que nos llega en el form
    //cuando ha un error de validacion se almacena en el binding result, siempre tiene que ir justo depsues del parametro a validar
    @PostMapping()
    public String procesar(@Valid @ModelAttribute("nuevoAnimal") AnimalDTO animal, BindingResult error, Model model, RedirectAttributes flash){
        //antes de crearlo comprobamos que no haya errores
        try {
            if (error.hasErrors()) {
                model.addAttribute("lista", animalService.obtenerAnimales());
                //si hay errores se vuelve al index
                return "index";
            }
            //si no hay errores llamamos al servicio para crear al animal
            AnimalDTO nuevo = animalService.crearAnimal(animal);
            flash.addFlashAttribute("mensaje", "Se creo el animal: "
                    + animal.getNombre() + " con id: " + animal.getId());
            //en un post SIEMPRE hay un redirect al final cuando se almacenan los datos
            return "redirect:/animal";
        } catch (ValidationException e) {
           error.reject("errorValidacion", e.getMessage());
           return "index";
        }
    }

}
