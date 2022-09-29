package com.apportfolio.mmm.Service;


import com.apportfolio.mmm.Entity.Experiencia;
import com.apportfolio.mmm.Entity.Persona;

import com.apportfolio.mmm.Repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PersonaService {

    //traer, save, delete, editar persona
    @Autowired
    PersonaRepo personaRepo;

    //trae una lista de personas
    public List<Persona> list() {
        return personaRepo.findAll();
    }

    //busca por id
    public Optional<Persona> getOne(int id){
        return personaRepo.findById(id);
    }

    //busca por nombre
    public Optional<Experiencia> getByNombrePersona(String nombrePersona){
        return personaRepo.findByNombrePersona(nombrePersona);
    }


    //guarda dato de tipo persona
    public void save(Persona pers) {
        personaRepo.save(pers);
    }

    public void delete(int id) {
        personaRepo.deleteById(id);
    }

    public boolean existsById(int id){
        return personaRepo.existsById(id);
    }

    public boolean existsByNombrePersona(String nombrePersona){
        return  personaRepo.existsByNombrePersona(nombrePersona);
    }





    /*

    public Persona editarPersona(Persona pers) {
        Persona persona = personaRepo.findById(1).orElse(null);
        persona.setNombre(pers.getNombre());
        persona.setApellido(pers.getApellido());
        persona.setAboutme(pers.getAboutme());
        persona.setOficio(pers.getOficio());

        return persona;
        //return personaRepo.save(pers);
    }


     */










}
