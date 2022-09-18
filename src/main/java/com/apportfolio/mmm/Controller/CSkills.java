package com.apportfolio.mmm.Controller;



import com.apportfolio.mmm.Dto.dtoSkills;
import com.apportfolio.mmm.Service.SSkills;
import com.apportfolio.mmm.Security.Controller.Mensaje;
import com.apportfolio.mmm.Entity.Skills;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skill")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontendmmm.web.app")



public class CSkills {

        @Autowired
        SSkills sSkills;

        @GetMapping("/lista")
        public ResponseEntity<List<Skills>> list() {
                List<Skills> list = sSkills.list();
                return new ResponseEntity<>(list, HttpStatus.OK);
        }

        // modifique Skills por ?
        @GetMapping("/detail/{id}")
        public ResponseEntity<?> getById(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)) {
        return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Skills skill = sSkills.getOne(id).get();
        return new ResponseEntity<>(skill, HttpStatus.OK);
        }

        //@PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)) {
        return new ResponseEntity<>(new Mensaje("No existe el ID, por favor indique otro"), HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity<>(new Mensaje("La Skill fue eliminada con exito"), HttpStatus.OK);
        }

        //@PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/create")
        public ResponseEntity<?> create(@RequestBody dtoSkills dtoskill) {
        if (StringUtils.isBlank(dtoskill.getNombreS())) {
        return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sSkills.existsByNombreS(dtoskill.getNombreS())) {
        return new ResponseEntity<>(new Mensaje("Esa Skill ya Existe, indique otra please"), HttpStatus.BAD_REQUEST);
        }

        Skills skill = new Skills(dtoskill.getNombreS(), dtoskill.getCapacidadS(),dtoskill.getTipoS());
        sSkills.save(skill);

        return new ResponseEntity<>(new Mensaje("Skill agregada con exito"), HttpStatus.OK);
        }

        //@PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/update/{id}")
        public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskill) {
        if (!sSkills.existsById(id)) {
        return new ResponseEntity<>(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (sSkills.existsByNombreS(dtoskill.getNombreS()) && sSkills.getByNombreS(dtoskill.getNombreS()).get().getId() != id) {
        return new ResponseEntity<>(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoskill.getNombreS())) {
        return new ResponseEntity<>(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Skills experiencia = sSkills.getOne(id).get();

        experiencia.setNombreS(dtoskill.getNombreS());
        experiencia.setCapacidadS(dtoskill.getCapacidadS());
        experiencia.setTipoS(dtoskill.getTipoS());

        sSkills.save(experiencia);

        return new ResponseEntity<>(new Mensaje("Skills actualizada"), HttpStatus.OK);
        }





}
