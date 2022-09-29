package com.apportfolio.mmm.Repository;


import com.apportfolio.mmm.Entity.Experiencia;
import com.apportfolio.mmm.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepo extends JpaRepository<Persona, Integer> {

    public Optional<Experiencia> findByNombrePersona(String nombre);
    public boolean existsByNombrePersona(String nombre);

}
