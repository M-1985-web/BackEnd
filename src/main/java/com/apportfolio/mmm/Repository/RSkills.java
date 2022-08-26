package com.apportfolio.mmm.Repository;


import com.apportfolio.mmm.Entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RSkills extends JpaRepository<Skills, Integer> {
    public Optional<Skills> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);






}
