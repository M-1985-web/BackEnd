package com.apportfolio.mmm.Repository;


import com.apportfolio.mmm.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


//interface de repository
@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Integer> {
  public Optional<Educacion> findByNombreEdu(String nombreEdu);
  public boolean existsByNombreEdu(String nombreEdu);

}









