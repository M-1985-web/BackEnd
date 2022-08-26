package com.apportfolio.mmm.Repository;


import com.apportfolio.mmm.Entity.NewProyec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReProyec extends JpaRepository<NewProyec, Integer> {

    public Optional<NewProyec> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
}
