package com.apportfolio.mmm.Security.Controller;

//este es paquete que se termina comunicando con nuestro front
import com.apportfolio.mmm.Security.Dto.JwtDto;
import com.apportfolio.mmm.Security.Dto.LoginUsuario;
import com.apportfolio.mmm.Security.Dto.NuevoUsuario;
import com.apportfolio.mmm.Security.Entity.Rol;
import com.apportfolio.mmm.Security.Entity.Usuario;
import com.apportfolio.mmm.Security.Enums.RolNombre;
import com.apportfolio.mmm.Security.Jwt.JwtProvider;
import com.apportfolio.mmm.Security.Service.RolService;
import com.apportfolio.mmm.Security.Service.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UsuarioService usuarioService;

  @Autowired
  RolService rolService;

  @Autowired
  JwtProvider jwtProvider;

  @PostMapping("/nuevo")
  //no lo piden pero aca creamos un usuario nuevo
  public ResponseEntity<?> nuevo(
    @Valid @RequestBody NuevoUsuario nuevoUsuario,
    BindingResult bindingResult
  ) {
    if (bindingResult.hasErrors()) return new ResponseEntity<>(
      new Mensaje("Campos incorrectos o email invalido"),
      HttpStatus.BAD_REQUEST
    );

    if (
      usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())
    ) return new ResponseEntity<>(
      new Mensaje("Nombre de usuario existente"),
      HttpStatus.BAD_REQUEST
    );

    if (
      usuarioService.existsByEmail(nuevoUsuario.getEmail())
    ) return new ResponseEntity<>(
      new Mensaje("Email existente"),
      HttpStatus.BAD_REQUEST
    );

    Usuario usuario = new Usuario(
      nuevoUsuario.getNombre(),
      nuevoUsuario.getNombreUsuario(),
      nuevoUsuario.getEmail(),
      passwordEncoder.encode(nuevoUsuario.getPassword())
    );

    Set<Rol> roles = new HashSet<>();
    roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

    if (nuevoUsuario.getRoles().contains("admin")) roles.add(
      rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get()
    );
    usuario.setRoles(roles);
    usuarioService.save(usuario);
    return new ResponseEntity<>(
      new Mensaje("Usuario guardado con exito"),
      HttpStatus.CREATED
    );
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(
    @Valid @RequestBody LoginUsuario loginUsuario,
    BindingResult bindingResult
  ) {
    //si contiene errores
    if (bindingResult.hasErrors()) return new ResponseEntity<>(
      new Mensaje("Campos mal ingresados"),
      HttpStatus.BAD_REQUEST
    );

    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        loginUsuario.getNombreUsuario(),
        loginUsuario.getPassword()
      )
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String jwt = jwtProvider.generateToken(authentication);

    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

    JwtDto jwtDto = new JwtDto(
      jwt,
      userDetails.getUsername(),
      userDetails.getAuthorities()
    );

    return new ResponseEntity<>(jwtDto, HttpStatus.OK);
  }
}
