package com.apportfolio.mmm.Repository;


import com.apportfolio.mmm.Entity.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSoftSkill extends JpaRepository<SoftSkill, Integer> {

    
}
