package com.apportfolio.mmm.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotNull
    private String nombreS;
    @Range(min = 0, max = 100, message = "Ingresa un valor entre 0 y 100")
    private int capacidadS;
    @NotNull
    private String tipoS;

    //constructores

    public Skills() {
    }

    public Skills(String nombreS,@Range(min = 1, max = 100) int capacidadS, String tipoS) {
        this.nombreS = nombreS;
        this.capacidadS = capacidadS;
        this.tipoS = tipoS;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public int getCapacidadS() {
        return capacidadS;
    }

    public void setCapacidadS(int capacidadS) {
        this.capacidadS = capacidadS;
    }

    public String getTipoS() {
        return tipoS;
    }

    public void setTipoS(String tipoS) {
        this.tipoS = tipoS;
    }





}
