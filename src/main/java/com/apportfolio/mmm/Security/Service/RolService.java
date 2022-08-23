package com.apportfolio.mmm.Security.Service;


import com.apportfolio.mmm.Security.Entity.Rol;
import com.apportfolio.mmm.Security.Enums.RolNombre;
import com.apportfolio.mmm.Security.Repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {

  @Autowired
  IRolRepository iRolRepository;

  public Optional<Rol> getByRolNombre(RolNombre rolNombre){
    return iRolRepository.findByRolNombre(rolNombre);
  }

  //metodo para guardar cambios
  public void save(Rol rol){
    iRolRepository.save(rol);
  }


}
