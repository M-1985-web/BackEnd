package com.apportfolio.mmm.Controller;


import com.apportfolio.mmm.Entity.Persona;
import com.apportfolio.mmm.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persona/")
@CrossOrigin(origins = "https://frontendmmm.web.app/")

public class PersonaController {
    @Autowired
    public IPersonaService iPersonaService;

    @GetMapping("traer")
    public List<Persona> getPersona() {
        return iPersonaService.getPersona();
    }

    //@PreAuthorize("hasRole('ADMIN')") //este renglón refiere a que estas acciones las puede hacer solo el administrador
    @PostMapping("crear")
    public String createPersona(@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        iPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    //URL:PUERTO/personas/editar/4/nombre & apellido & img
    @PutMapping("editar/{id}")
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

    @GetMapping("traer/perfil")
    public Persona findPersona(){
        return iPersonaService.findPersona((long)1);
    }

}
