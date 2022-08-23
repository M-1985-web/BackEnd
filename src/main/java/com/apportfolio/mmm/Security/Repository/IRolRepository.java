package com.apportfolio.mmm.Security.Repository;


import com.apportfolio.mmm.Security.Entity.Rol;
import com.apportfolio.mmm.Security.Enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
  Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
