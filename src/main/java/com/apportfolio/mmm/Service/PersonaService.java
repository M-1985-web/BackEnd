package com.apportfolio.mmm.Service;


import com.apportfolio.mmm.Entity.Persona;
import com.apportfolio.mmm.Interface.IPersonaService;
import com.apportfolio.mmm.Repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class PersonaService implements IPersonaService {
    @Autowired
    PersonaRepo personaRepo;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = personaRepo.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepo.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = personaRepo.findById(id).orElse(null);
        return persona;

    }


}
