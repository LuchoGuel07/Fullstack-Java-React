package net.projectjava.backendjava.services;

import net.projectjava.backendjava.shared.dto.UserDto;

public interface UserServiceInterface {
    //Definimos metodo para crear un usuario

    public UserDto createUser(UserDto user);
    
}
