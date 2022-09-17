package com.apportfolio.mmm.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



import java.util.List;


//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Entity

public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank
    @Size(min = 1, max = 50, message = "no cumple con la longitud, minimo 1 caracteres maximo 50")
    private String nombre;
    
    @NotBlank
    @Size(min = 1, max = 50, message = "no cumple con la longitud, minimo 1 caracteres maximo 50")
    private String apellido;

    @Size(min = 1, max = 50, message = "no cumple con la longitud, minimo 1 caracteres maximo 50")
    private String img;

    //desde aca

    //contructores
    public Persona() {
    }

    public Persona(String nombre, String apellido, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
    }

    //getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }



    //esta llave no se borra
}
