package org.example.prueba.Controllers;

import org.example.prueba.Exception.ValidarDatosExcepcion;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejadorExcepciones {

    @ExceptionHandler(ValidarDatosExcepcion.class)

    public String validarDatos(){
        return "errorValidacion";
    }
}
