package com.apportfolio.mmm.Service;


import com.apportfolio.mmm.Entity.Persona;

import com.apportfolio.mmm.Repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class PersonaService {

    @Autowired
    private final PersonaRepo personaRepo;

    @Autowired
    public PersonaService(PersonaRepo personaRepo){
        this.personaRepo = personaRepo;
    }

    public List<Persona> buscarPersona(){
        return personaRepo.findAll();
    }

    public Persona editpersona(Persona pers){
        return personaRepo.save(pers);
    }

    public void borrapersona(int id){
        personaRepo.deleteById(id);
    }

    public Persona BuscarporId(int id){
        Persona pers = personaRepo.findById(id).orElse(null);
        return pers;
    }

}
