package net.projectjava.backendjava.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.projectjava.backendjava.UserRepository;
import net.projectjava.backendjava.entities.UserEntity;
import net.projectjava.backendjava.shared.dto.UserDto;

@Service
public class UserService implements UserServiceInterface{



    @Autowired
    UserRepository userRepository;
    //Sobre escribimos tras implementar el metodo de la interfaz
    @Override
    public UserDto createUser(UserDto user) {
        //TODO Logica para crear el usuario 

        UserEntity userEntity = new UserEntity(); //Creamos una instancia de la clase UserEntity
        BeanUtils.copyProperties(user, userEntity); //Copiamos los valores de user a userEntity


        userEntity.setEncryptedPassword("encryptedPassword");
        userEntity.setUserID("userID");

        UserEntity storedUserDetails = userRepository.save(userEntity); //Guardamos el usuario en la base de datos


        UserDto userToReturn = new UserDto(); //Creamos una instancia de la clase UserDto
        BeanUtils.copyProperties(storedUserDetails, userToReturn); //Copiamos los valores de userEntity a userToReturn

        return userToReturn; //Devolvemos el usuario creado
    }
    
}
