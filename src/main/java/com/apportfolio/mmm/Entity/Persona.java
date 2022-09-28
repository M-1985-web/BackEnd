package com.apportfolio.mmm.Entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size(min = 1, max = 50, message = "nombre muy extenso, por favor agregar otro")
    private String nombre;
    @NotBlank
    @Size(min = 1, max = 50, message = " apellido muy extenso, por favor agregar otro")
    private String apellido;

    @NotBlank
    @Size(min = 30, max = 1000, message = "Acerca de excedio los caracteres permitidos")
    private String aboutme;

    @NotBlank
    @Size(min = 1, max = 50, message = "muy extenso, por favor agregar otro")
    private String oficio;

    @Size(min = 1, max = 50, message = "no ha ingresado la imagen, maximo 45 caracteres")
    private String imgurl;


    //constructores


    public Persona() {
    }

    public Persona(@NotBlank String nombre, @NotBlank String apellido, String imgurl, @NotBlank String aboutme,
                   @NotBlank String oficio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imgurl = imgurl;
        this.aboutme = aboutme;
        this.oficio = oficio;
    }



}
