package com.apportfolio.mmm.Service;


import com.apportfolio.mmm.Entity.Persona;

public interface IPersonaService {
    public Persona traerPersona();
    public void savePersona(Persona persona);
    public void deletePersona(int id);
    public Persona editarPersona(Persona persona);
}
