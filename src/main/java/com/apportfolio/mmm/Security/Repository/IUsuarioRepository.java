package com.apportfolio.mmm.Security.Repository;



import com.apportfolio.mmm.Security.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
  Optional<Usuario> findByNombreUsuario(String nombreUsuario);

  boolean  existsByNombreUsuario(String nombreUsuario);
  boolean  existsByEmail(String email);


}
