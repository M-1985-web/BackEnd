package com.apportfolio.mmm.Repository;


import com.apportfolio.mmm.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo extends JpaRepository<Persona, Integer> {
    Persona getReferenceById(int i);
}
