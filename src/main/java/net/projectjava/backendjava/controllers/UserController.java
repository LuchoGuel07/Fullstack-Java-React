package net.projectjava.backendjava.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user") //localhost:8080/user
public class UserController {
    
    /**
     * Esta función es una solicitud GET que devuelve una cadena
     * 
     * @return Una cuerda
     */
    @GetMapping
    public String getUser() {
        return "Get user details";
    }

    /**
     * La función se llama createUser y devuelve una cadena
     * 
     * @return Una cuerda
     */
    @PostMapping
    public String createUser() {
        return "Create user";
    }

}