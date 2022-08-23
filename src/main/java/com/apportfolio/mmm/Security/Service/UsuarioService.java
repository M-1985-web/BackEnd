package com.apportfolio.mmm.Security.Service;


import com.apportfolio.mmm.Security.Entity.Usuario;
import com.apportfolio.mmm.Security.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
  @Autowired
  IUsuarioRepository iUsuarioRepository;

  public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
    return iUsuarioRepository.findByNombreUsuario(nombreUsuario);
  }

  //otro metodo booleano, si el nombre de usuario existe
  public boolean existsByNombreUsuario(String nombreUsuario) {
    return iUsuarioRepository.existsByNombreUsuario(nombreUsuario);
  }

  //otro metodo booleano, si el email existe
  public boolean existsByEmail(String email) {
    return iUsuarioRepository.existsByEmail(email);
  }

  //metodo que guarda un usuario nuevo
  public void save(Usuario usuario){
    iUsuarioRepository.save(usuario);
  }






}
