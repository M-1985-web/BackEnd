

package com.apportfolio.mmm.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Experiencia {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @NotBlank
  private String nombreE;
  @NotBlank
  private String descripcionE;

  private String imgE;

  //contructores
  public Experiencia() {
  }

  public Experiencia(String nombreE, String descripcionE, String imgE) {
    this.nombreE = nombreE;
    this.descripcionE = descripcionE;
    this.imgE = imgE;
  }
  // getters & setters


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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

  public String getImgE() {
    return imgE;
  }

  public void setImgE(String imgE) {
    this.imgE = imgE;
  }


}



