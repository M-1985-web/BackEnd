package com.apportfolio.mmm.Security.Controller;




//va a controlar los mensajes


public class Mensaje {
  private String mensaje;

  //constructores

  public Mensaje() {
  }

  public Mensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  //getters && setters

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }
}
