
package com.apportfolio.mmm.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {
  @NotBlank
  private String nombreE;
  @NotBlank
  private String descripcionE;


  //constructores

  public DtoExperiencia() {
  }

  public DtoExperiencia(String nombreE, String descripcionE) {
    this.nombreE = nombreE;
    this.descripcionE = descripcionE;
  }

  //getter y setter


  public String getNombreE() {
    return nombreE;
  }

  public void setNombreE(String nombreE) {
    this.nombreE = nombreE;
  }

  public String getDescripcionE() {
    return descripcionE;
  }

  public void setDescripcionE(String descripcionE) {
    this.descripcionE = descripcionE;
  }




}



