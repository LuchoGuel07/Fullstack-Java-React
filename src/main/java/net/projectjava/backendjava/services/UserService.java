package net.projectjava.backendjava.services;

import org.springframework.stereotype.Service;

import net.projectjava.backendjava.shared.dto.UserDto;

@Service
public class UserService implements UserServiceInterface{


    //Sobre escribimos tras implementar el metodo de la interfaz
    @Override
    public UserDto createUser(UserDto user) {
        //TODO Logica para crear el usuario 
        return null;
    }
    
}
