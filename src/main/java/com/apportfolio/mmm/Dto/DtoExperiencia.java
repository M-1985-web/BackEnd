
package com.apportfolio.mmm.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {
  @NotBlank
  private String nombreExperiencia;
  @NotBlank
  private String descripcionExperiencia;

  private String imgExperiencia;


  //constructores

  public DtoExperiencia() {
  }

  public DtoExperiencia(String nombreExperiencia, String descripcionExperiencia, String imgExperiencia) {
    this.nombreExperiencia = nombreExperiencia;
    this.descripcionExperiencia = descripcionExperiencia;
    this.imgExperiencia = imgExperiencia;
  }

  //getter y setter


  public String getNombreExperiencia() {
    return nombreExperiencia;
  }

  public void setNombreExperiencia(String nombreExperiencia) {
    this.nombreExperiencia = nombreExperiencia;
  }

  public String getDescripcionExperiencia() {
    return descripcionExperiencia;
  }

  public void setDescripcionExperiencia(String descripcionExperiencia) {
    this.descripcionExperiencia = descripcionExperiencia;
  }

  public String getImgExperiencia() {
    return imgExperiencia;
  }

  public void setImgExperiencia(String imgExperiencia) {
    this.imgExperiencia = imgExperiencia;
  }




}



