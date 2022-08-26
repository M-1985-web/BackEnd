package com.apportfolio.mmm.Dto;




public class dtoSoftSkill {
    private String nombreS;
    private int capacidadS;
    private String tipoS;

    //constructores

    public dtoSoftSkill() {
    }

    public dtoSoftSkill(String nombreS, int capacidadS, String tipoS) {
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
