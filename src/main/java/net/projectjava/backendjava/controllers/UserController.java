package net.projectjava.backendjava.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.projectjava.backendjava.models.UserDetailRequestModel;
import net.projectjava.backendjava.models.responses.UserRest;
import net.projectjava.backendjava.services.UserServiceInterface;
import net.projectjava.backendjava.shared.dto.UserDto;

@RestController
@RequestMapping("/user") //localhost:8080/user
public class UserController {
    
    //interfaz para no crear más instancias –Para no estar llamando a “userService” cada vez que se necesite una instancia de UserService
    @Autowired
    UserServiceInterface userService;
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
     //@RequestBody convierte de JSON a java
    @PostMapping
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetails) {
        
    //Cuando realizamos una petición Json, Spring nos devuelve un objeto de tipo UserDetailRequestModel, tenemos todos los datos del cliente 

       // Crear una nueva instancia de la clase UserRest y establecer los valores de la instancia en
       // los valores de la instancia de userDetails.
        UserRest userReturnValue = new UserRest();
        //Creamos objeto DTO para enviarlo a la logica de nuestra aplicación
        UserDto userDto = new UserDto();

        // Copiar los valores de userDetails a userDto -- De un objeto a otro 
        //Se usa para enviar el objeto a la logica 
        BeanUtils.copyProperties(userDetails, userDto);
        
        //Creación para seguridad y tener la aplicación bien organizada y para saber para que se usa cada una de las clases
        UserDto createdUser = userService.createUser(userDto);
        
        // Copiar las propiedades de un objeto a otro.
        BeanUtils.copyProperties(createdUser, userReturnValue);

        return userReturnValue;


    }

}