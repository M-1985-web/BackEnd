

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
  private String nombreExperiencia;
  @NotBlank
  private String descripcionExperiencia;

  private String imgExperiencia;

  //contructores
  public Experiencia() {
  }

  public Experiencia(String nombreExperiencia, String descripcionExperiencia, String imgExperiencia) {
    this.nombreExperiencia = nombreExperiencia;
    this.descripcionExperiencia = descripcionExperiencia;
    this.imgExperiencia = imgExperiencia;
  }
  // getters & setters


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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



