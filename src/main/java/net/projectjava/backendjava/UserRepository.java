package net.projectjava.backendjava;

import org.springframework.data.repository.CrudRepository;

import net.projectjava.backendjava.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    
    
    
    UserEntity findByEmail(String email); //Metodo para buscar un usuario por email (Datos de UserEntity)
    
}
