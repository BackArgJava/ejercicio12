package com.example.Ejercicio4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
@GetMapping("/holaComoestas") // con esto coloccaremos la dirección de la url
    public String holaComoestas() {
        return "Bien y vos?";
    }

}
