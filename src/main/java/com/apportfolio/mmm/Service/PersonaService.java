package com.apportfolio.mmm.Service;


import com.apportfolio.mmm.Entity.Persona;
import com.apportfolio.mmm.Repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class PersonaService implements IPersonaService {
    @Autowired
    PersonaRepo personaRepo;

    @Override
    public void deletePersona(int id) {
        personaRepo.deleteById(1);

    }

    @Override
    public Persona editarPersona(Persona nuevaPersona) {
        Persona persona = personaRepo.findById(1).orElse(null);
        persona.setNombre(nuevaPersona.getNombre());
        persona.setApellido(nuevaPersona.getApellido());
        persona.setImgurl(nuevaPersona.getImgurl());
        persona.setAboutme(nuevaPersona.getAboutme());
        persona.setOficio(nuevaPersona.getOficio());

        return persona;
    }

    @Override
    public void savePersona(Persona persona) {personaRepo.save(persona);}

    @Override
    public Persona traerPersona() {
        return personaRepo.getById(1);
        //getReferenceById(1);
    }



}
