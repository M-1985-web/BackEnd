package com.apportfolio.mmm.Dto;


import javax.validation.constraints.NotBlank;




public class DtoEducacion {
  @NotBlank
  private String nombreEdu;
  @NotBlank
  private String descripcionEdu;

  private String imgEdu;



  //constructores

  public DtoEducacion() {
  }

  public DtoEducacion(String nombreEdu, String descripcionEdu, String imgEdu) {
    this.nombreEdu = nombreEdu;
    this.descripcionEdu = descripcionEdu;
    this.imgEdu = imgEdu;
  }

  //getters and setters


  public String getNombreEdu() {
    return nombreEdu;
  }

  public void setNombreEdu(String nombreEdu) {
    this.nombreEdu = nombreEdu;
  }

  public String getDescripcionEdu() {
    return descripcionEdu;
  }

  public void setDescripcionEdu(String descripcionEdu) {
    this.descripcionEdu = descripcionEdu;
  }

  public String getImgEdu() {
    return imgEdu;
  }

  public void setImgEdu(String imgEdu) {
    this.imgEdu = imgEdu;
  }






}
