package com.apportfolio.mmm.Controller;


import com.apportfolio.mmm.Entity.Persona;

import com.apportfolio.mmm.Service.IPersonaService;
//import com.apportfolio.mmm.Service.PersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persona/")
@CrossOrigin(origins = "https://frontendmmm.web.app/")



//persona controller
public class PersonaController {

    public IPersonaService iPersonaService;

    @GetMapping("traer")
    public ResponseEntity<?> mostrarUsuario() {
        Persona persona = iPersonaService.traerPersona();
        if (persona == null) {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @PostMapping("crear")
    public ResponseEntity<?> agregarPersona(@RequestBody Persona perso) {
        if (StringUtils.isBlank(perso.getNombre())
                && StringUtils.isBlank(perso.getApellido())
                && StringUtils.isBlank(perso.getAboutme())
                && StringUtils.isBlank(perso.getOficio())) {
            return new ResponseEntity<>("Campos obligatorios vacios", HttpStatus.BAD_REQUEST);
        }
        iPersonaService.savePersona(perso);
        return new ResponseEntity<>("Persona creada exitosamente", HttpStatus.OK);
    }

    @PutMapping("editar")
    public ResponseEntity<?> editar(@RequestBody Persona persona) {
        if (StringUtils.isBlank(persona.getNombre())
                && StringUtils.isBlank(persona.getApellido())
                && StringUtils.isBlank(persona.getAboutme())
                && StringUtils.isBlank(persona.getOficio())) {
            return new ResponseEntity<>("Campos obligatorios vacios", HttpStatus.BAD_REQUEST);
        }
        Persona personaEditada = iPersonaService.editarPersona(persona);
        return new ResponseEntity<>(personaEditada, HttpStatus.OK);
    }



    /*
    public PersonaController(PersonaService personaService){
        this.iPersonaService = personaService;
    }

    @GetMapping("buscar")
    public ResponseEntity<Persona> buscarPersona(@PathVariable("id")int id){
        Persona pers = personaService.BuscarporId(id);
        return new ResponseEntity<>(pers, HttpStatus.OK);
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("editar")
    public ResponseEntity<Persona> editarPersona(@PathVariable("id")int id,@RequestBody Persona pers){
        Persona editpers = personaService.editpersona(pers);
        return new ResponseEntity<>(editpers, HttpStatus.OK);
    }





    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        personaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    */

}
