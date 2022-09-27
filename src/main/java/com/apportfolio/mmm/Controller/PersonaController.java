package com.apportfolio.mmm.Controller;


import com.apportfolio.mmm.Entity.Persona;

import com.apportfolio.mmm.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping("persona/")
@CrossOrigin(origins = "https://frontendmmm.web.app/")
=======
@RequestMapping("persona")
@CrossOrigin(origins = "https://frontendmmm.web.app")
>>>>>>> f806bae90ba533dcc1ef6fdca8b623be30d6987e

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

}
