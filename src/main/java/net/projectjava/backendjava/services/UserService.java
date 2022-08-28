package net.projectjava.backendjava.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.projectjava.backendjava.UserRepository;
import net.projectjava.backendjava.entities.UserEntity;
import net.projectjava.backendjava.shared.dto.UserDto;

@Service
public class UserService implements UserServiceInterface{



    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder; //Encriptar contraseña
    
    //Sobre escribimos tras implementar el metodo de la interfaz
    @Override
    public UserDto createUser(UserDto user) {

       // Comprobando si el usuario ya existe en la base de datos.
        if(userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("El correo electronico ya existe");
        }

        UserEntity userEntity = new UserEntity(); //Creamos una instancia de la clase UserEntity
        BeanUtils.copyProperties(user, userEntity); //Copiamos los valores de user a userEntity


        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword())); //Encriptamos la contraseña

        UUID userID = UUID.randomUUID(); //Generamos un UUID para el id del usuario

        userEntity.setUserID(userID.toString()); //Asignamos el UUID al id del usuario

        UserEntity storedUserDetails = userRepository.save(userEntity); //Guardamos el usuario en la base de datos


        UserDto userToReturn = new UserDto(); //Creamos una instancia de la clase UserDto
        BeanUtils.copyProperties(storedUserDetails, userToReturn); //Copiamos los valores de userEntity a userToReturn

        return userToReturn; //Devolvemos el usuario creado
    }
    
}
