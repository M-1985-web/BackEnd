package com.apportfolio.mmm.Interface;

import com.apportfolio.mmm.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    //traer una lista de persona
    public List<Persona> getPersona();
    
    //guardar un objeto de tipo persona
    public void savePersona(Persona persona);

    //eliminar un objeto usuario buscado por id
    public void deletePersona(Long id);

    //buscar una persona por ID
    public Persona findPersona(Long id);
}
