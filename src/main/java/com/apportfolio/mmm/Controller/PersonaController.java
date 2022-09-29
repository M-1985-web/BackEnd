package com.apportfolio.mmm.Controller;


import com.apportfolio.mmm.Dto.DtoExperiencia;
import com.apportfolio.mmm.Dto.DtoPersona;
import com.apportfolio.mmm.Entity.Experiencia;
import com.apportfolio.mmm.Entity.Persona;

import com.apportfolio.mmm.Security.Controller.Mensaje;
import com.apportfolio.mmm.Service.PersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "https://frontendmmm.web.app")



//persona controller
public class PersonaController {

    public PersonaService personaService;


    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List <Persona> list = personaService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        if (!personaService.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtoper){
        if(StringUtils.isBlank(dtoper.getNombre()))
            return new ResponseEntity<>(new Mensaje("el nombre es obigatorio, POR FAVOR AGREGAR UNO"), HttpStatus.BAD_REQUEST);
        if(personaService.existsByNombrePersona(dtoper.getNombre()))
            return new ResponseEntity<>(new Mensaje("el nombre ya existe"), HttpStatus.BAD_REQUEST);

        Persona persona = new Persona(
                dtoper.getNombre(), dtoper.getOficio(), dtoper.getImgurl(), dtoper.getApellido(), dtoper.getAboutme()
        );
        personaService.save(persona);

        return new ResponseEntity<>(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }



    //corregimos o cambiamos datos EDITAR
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoper) {
        //validamos si existe tal id
        if(!personaService.existsById(id))
            return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

        //compara si dos experiencias son similares
        if(personaService.existsByNombrePersona(dtoper.getNombre()) && personaService.getByNombrePersona(dtoper.getNombre()).get().getId()!=id)
            return new ResponseEntity<>(new Mensaje("ya existe la experiencia"), HttpStatus.BAD_REQUEST);

        //el campo no puede estar vacio
        if(StringUtils.isBlank(dtoper.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);

        //replicar los 3 if con descripcion


        //arriba los filtros
        //si trae el dato correcto
        Persona persona= personaService.getOne(id).get();
        persona.setNombre(dtoper.getNombre());
        persona.setApellido(dtoper.getApellido());
        persona.setAboutme(dtoper.getAboutme());
        persona.setOficio(dtoper.getOficio());
        //experiencia.setImgE(dtoexp.getImgE());

        personaService.save(persona);
        return new ResponseEntity<>(new Mensaje("Experiencia actualizada correctamente"), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //validamos si existe id
        if(!personaService.existsById(id))
            return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);

        personaService.delete(id);

        return new ResponseEntity<>(new Mensaje("Se elimino correctamente la experiencia"), HttpStatus.OK);
    }






    /*
    @GetMapping("/traer")
    public ResponseEntity<?> mostrarUsuario() {
        Persona persona = iPersonaService.traerPersona();
        if (persona == null) {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @PostMapping("/crear")
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

    @PutMapping("/editar")
    public ResponseEntity<?> editar(@RequestBody Persona pers) {
        if (StringUtils.isBlank(persona.getNombre())
                && StringUtils.isBlank(persona.getApellido())
                && StringUtils.isBlank(persona.getAboutme())
                && StringUtils.isBlank(persona.getOficio())) {
            return new ResponseEntity<>("Campos obligatorios vacios", HttpStatus.BAD_REQUEST);
        }
        Persona personaEditada = iPersonaService.editarPersona(persona);
        return new ResponseEntity<>(personaEditada, HttpStatus.OK);
    }




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
