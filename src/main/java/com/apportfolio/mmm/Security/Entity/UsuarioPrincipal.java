package com.apportfolio.mmm.Security.Entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class UsuarioPrincipal implements UserDetails {
  private String nombre;
  private String nombreUsuario;
  private String email;
  private String password;
  private Collection<? extends GrantedAuthority> authorities;

  //contructor


  public UsuarioPrincipal(String nombre, String nombreUsuario, String email, String password, Collection<? extends GrantedAuthority> authorities) {
    this.nombre = nombre;
    this.nombreUsuario = nombreUsuario;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
  }

  public static UsuarioPrincipal build(Usuario usuario) {
    List<GrantedAuthority> authorities = usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
    return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword(), authorities);
  }


  //implementacion de metodos abstractos linea 13

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  // como el metodo no existe lo agrego manual y le borro el @Override
  public String getNombre() {
    return nombre;
  }

  // como el metodo no existe lo agrego manual y le borro el @Override
  public String getEmail() {
    return email;
  }

  @Override
  public String getUsername() {
    return nombreUsuario;
  }

  //esta logueado si o no?
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  // la cuenta esta bloqueada
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  // la contraseña expiro?
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  // Esta habilitado?
  @Override
  public boolean isEnabled() {
    return true;
  }

}
