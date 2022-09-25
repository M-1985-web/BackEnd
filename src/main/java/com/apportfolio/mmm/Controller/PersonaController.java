package com.apportfolio.mmm.Controller;


import com.apportfolio.mmm.Entity.Persona;
import com.apportfolio.mmm.Service.IPersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/persona")
@CrossOrigin(origins = "https://frontendmmm.web.app")

public class PersonaController {
    @Autowired
    public IPersonaService iPersonaService;

    @GetMapping("/persona/traer")
    public List<Persona> getPersona() {
        return iPersonaService.getPersona();
    }

    //@PreAuthorize("hasRole('ADMIN')") //este renglón refiere a que estas acciones las puede hacer solo el administrador
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        iPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    //URL:PUERTO/personas/editar/4/nombre & apellido & img
    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("imgurl") String nuevoImgurl,
                               @RequestParam("oficio") String nuevoOficio,
                               @RequestParam("aboutme") String nuevoAboutme){
        Persona persona = iPersonaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImgurl(nuevoImgurl);
        persona.setOficio(nuevoOficio);
        persona.setAboutme(nuevoAboutme);

        iPersonaService.savePersona(persona);
        return persona;
    }

    @GetMapping("/persona/traer/perfil")
    public Persona findPersona(){
        return iPersonaService.findPersona((long)1);
    }

}
