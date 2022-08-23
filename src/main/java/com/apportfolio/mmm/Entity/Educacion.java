package com.apportfolio.mmm.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String nombreEdu;
  private String descripcionEdu;


  //contructor vacio y contructor completo, menos id
  public Educacion() {
  }

  public Educacion(String nombreEdu, String descripcionEdu) {
    this.nombreEdu = nombreEdu;
    this.descripcionEdu = descripcionEdu;
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
}
