
package com.apportfolio.mmm.Repository;

import com.apportfolio.mmm.Entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IExperienciaRepository extends JpaRepository <Experiencia, Integer>{
  public Optional<Experiencia> findByNombreExperiencia(String nombreExperiencia);
  public boolean existsByNombreExperiencia(String nombreExperiencia);
}

