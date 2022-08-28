package net.projectjava.backendjava;

import org.springframework.data.repository.CrudRepository;

import net.projectjava.backendjava.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    
    public UserEntity findByUserID(String userID);
    
    
}
