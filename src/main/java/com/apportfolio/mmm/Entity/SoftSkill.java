package com.apportfolio.mmm.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class SoftSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombreS;
    private int capacidadS;
    private String tipoS;

    //constructores

    public SoftSkill() {
    }

    public SoftSkill(String nombreS, int capacidadS, String tipoS) {
        this.nombreS = nombreS;
        this.capacidadS = capacidadS;
        this.tipoS = tipoS;
    }

    //Getters
    //and
    //Setters

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
