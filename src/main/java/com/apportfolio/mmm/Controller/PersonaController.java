package com.apportfolio.mmm.Controller;


import com.apportfolio.mmm.Entity.Persona;

import com.apportfolio.mmm.Service.PersonaService;
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
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService){
        this.personaService = personaService;
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable("id")int id){
        Persona pers = personaService.BuscarporId(id);
        return new ResponseEntity<>(pers, HttpStatus.OK);
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update/{id}")
    public ResponseEntity<Persona> editarPersona(@PathVariable("id")int id,@RequestBody Persona pers){
        Persona editpers = personaService.editpersona(pers);
        return new ResponseEntity<>(editpers, HttpStatus.OK);
    }

    /*
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        personaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    */

}
