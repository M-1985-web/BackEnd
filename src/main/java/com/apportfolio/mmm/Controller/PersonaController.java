package com.apportfolio.mmm.Controller;

import com.apportfolio.mmm.Entity.Persona;
import com.apportfolio.mmm.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
  @Autowired
  IPersonaService ipersonaService;

  @GetMapping("/personas/traer")
  public List<Persona> getPersona() {
    return ipersonaService.getPersona();
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/personas/crear")
  public String createPersona(@RequestBody Persona persona) {
    ipersonaService.savePersona(persona);
    return "La persona fue creada correctamente";
  }

  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/personas/borrar/{id}")
  public String deletePersona(@PathVariable Long id) {
    ipersonaService.deletePersona(id);
    return "La persona fue eliminada correctamente";
  }

  @PreAuthorize("hasRole('ADMIN')")
  // URL:PUERTO/personas/editar/4/nombre & apellido & img
  @PutMapping("/personas/editar/{id}")
  public Persona editPersona(@PathVariable Long id,
      @RequestParam("nombre") String nuevoNombre,
      @RequestParam("apellido") String nuevoApellido,
      @RequestParam("img") String nuevoImg) {

    // lo primero que hacemos es buscar la persona que queremos eliminar
    Persona persona = ipersonaService.findPersona(id);

    // estos son los nuevos cambios que obtendran las variables
    persona.setNombre(nuevoNombre);
    persona.setApellido(nuevoApellido);
    persona.setImg(nuevoImg);

    // aca guarda los cambios nuevos en el objeto persona
    ipersonaService.savePersona(persona);
    return persona;
  }

  @GetMapping("/personas/traer/perfil")
  public Persona findPersona() {

    return ipersonaService.findPersona((long) 3);
  }

}
