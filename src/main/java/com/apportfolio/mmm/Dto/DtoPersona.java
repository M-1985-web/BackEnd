package com.apportfolio.mmm.Dto;

import javax.validation.constraints.NotBlank;

public class DtoPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String aboutme;
    @NotBlank
    private String oficio;

    private String imgurl;


    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String aboutme, String oficio, String imgurl) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.aboutme = aboutme;
        this.oficio = oficio;
        this.imgurl = imgurl;
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

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
