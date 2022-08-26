package com.apportfolio.mmm.Dto;


import javax.validation.constraints.NotBlank;



public class dtoSkills {
    @NotBlank
    private String nombreS;
    @NotBlank
    private int capacidadS;
    @NotBlank
    private String tipoS;

    //constructores

    public dtoSkills() {
    }

    public dtoSkills(String nombreS, int capacidadS, String tipoS) {
        this.nombreS = nombreS;
        this.capacidadS = capacidadS;
        this.tipoS = tipoS;
    }

    //getters and setters

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
