
package com.apportfolio.mmm.Service;

import com.apportfolio.mmm.Entity.Experiencia;
import com.apportfolio.mmm.Repository.IExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImplementExperienciaService {
  @Autowired
  IExperienciaRepository iExperienciaRepository;

  //me arma una lista con todas las experiencias
  public List<Experiencia> list() {
    return iExperienciaRepository.findAll();
  }

  //busca por id
  public Optional<Experiencia> getOne(int id){
    return iExperienciaRepository.findById(id);
  }

  //busca por nombre
  public Optional<Experiencia> getByNombreE(String nombreE){
    return iExperienciaRepository.findByNombreE(nombreE);
  }

  //guarda dato de tipo experiencia
  public void save(Experiencia expe) {
    iExperienciaRepository.save(expe);
  }

  public void delete(int id) {
    iExperienciaRepository.deleteById(id);
  }

  public boolean existsById(int id){
    return iExperienciaRepository.existsById(id);
  }

  public boolean existsByNombreE(String nombreE){
    return iExperienciaRepository.existsByNombreE(nombreE);
  }





}

