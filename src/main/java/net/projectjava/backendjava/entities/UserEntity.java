package net.projectjava.backendjava.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Definimos una entidad para el usuario con una clave compuesta
@Entity(name="users")
public class UserEntity implements Serializable{
    

    private static final long serialVersionUID = 1L;

    //Definimos datos para la creación de los campos de la tabla de la base de datos
    @Id
    // Una anotación JPA para definir la estrategia de generación de clave principal.
    @GeneratedValue
    private long id;
    
    @Column(nullable = false)
    private String userID;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false)
    private String encryptedPassword;
    


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEncryptedPassword() {
        return encryptedPassword;
    }
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

}
