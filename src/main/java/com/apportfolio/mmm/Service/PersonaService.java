package com.apportfolio.mmm.Service;


import com.apportfolio.mmm.Entity.Persona;

import com.apportfolio.mmm.Repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class PersonaService implements IPersonaService{

    //traer, save, delete, editar persona
    @Autowired
    PersonaRepo personaRepo;

    //borrar
    @Override
    public void deletePersona(int id) {
        personaRepo.deleteById(id);
    }



    //editar
    @Override
    public Persona editarPersona(Persona pers) {
        Persona persona = personaRepo.findById(1).orElse(null);
        persona.setNombre(pers.getNombre());
        persona.setApellido(pers.getApellido());
        persona.setImgurl(pers.getImgurl());
        persona.setAboutme(pers.getAboutme());
        persona.setOficio(pers.getOficio());

        return persona;
        //return personaRepo.save(pers);
    }


    //save

    @Override
    public void savePersona(Persona persona) {

        personaRepo.save(persona);

    }



    //traer

    @Override
    public Persona traerPersona() {
        return personaRepo.getReferenceById(1);
    }



    /*
    public PersonaService(PersonaRepo personaRepo){
        this.personaRepo = personaRepo;
    }

    public List<Persona> buscarPersona(){
        return personaRepo.findAll();
    }


    public Persona BuscarporId(int id){
        Persona pers = personaRepo.findById(id).orElse(null);
        return pers;
    }

     */

}
