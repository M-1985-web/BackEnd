package com.apportfolio.mmm.Service;

import com.apportfolio.mmm.Entity.Experiencia;
import com.apportfolio.mmm.Entity.Persona;
import com.apportfolio.mmm.Interface.IPersonaService;
import com.apportfolio.mmm.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//agrege transactional ojo ver como funciona
import javax.persistence.Id;
import javax.transaction.Transactional;

@Service
@Transactional
public class ImplementPersonaService implements IPersonaService {
    @Autowired IPersonaRepository ipersonaRepository;
    
    
    //trae lista
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }

    //--------------------esto agrego nuevo









    //este no se borra por las dudas
}
