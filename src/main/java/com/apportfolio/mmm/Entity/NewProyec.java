package com.apportfolio.mmm.Entity;


//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class NewProyec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcionP;
    private String img;




    //constructor

    public NewProyec() {
    }


    public NewProyec(String titulo, String descripcionP, String img) {
        this.titulo = titulo;
        this.descripcionP = descripcionP;
        this.img = img;

    }

    //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setPDescripcion(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}
