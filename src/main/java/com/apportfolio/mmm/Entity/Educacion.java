package com.apportfolio.mmm.Entity;


//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Educacion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @NotBlank
  private String nombreEdu;
  @NotBlank
  private String descripcionEdu;

  private String imgEdu;


  //contructor vacio y contructor completo, menos id
  public Educacion() {
  }

  public Educacion(String nombreEdu, String descripcionEdu, String imgEdu) {
    this.nombreEdu = nombreEdu;
    this.descripcionEdu = descripcionEdu;
    this.imgEdu = imgEdu;
  }


  //getters and setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombreEdu() {
    return nombreEdu;
  }

  public void setNombreEdu(String nombreE) {
    this.nombreEdu = nombreE;
  }

  public String getDescripcionEdu() {
    return descripcionEdu;
  }

  public void setDescripcionEdu(String descripcionE) {
    this.descripcionEdu = descripcionE;
  }

  public String getImgEdu() {
    return imgEdu;
  }

  public void setImgEdu(String imgEdu) {
    this.imgEdu = imgEdu;
  }




}
