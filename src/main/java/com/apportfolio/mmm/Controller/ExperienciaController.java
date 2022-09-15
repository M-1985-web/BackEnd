package com.apportfolio.mmm.Controller;


import com.apportfolio.mmm.Dto.DtoExperiencia;
import com.apportfolio.mmm.Entity.Experiencia;
import com.apportfolio.mmm.Security.Controller.Mensaje;
import com.apportfolio.mmm.Service.ImplementExperienciaService;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@RequestMapping("/explab")
@RequestMapping("experiencia")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://frontendmmm.web.app")


public class ExperienciaController {
  @Autowired
  ImplementExperienciaService implementExperienciaService;

  //nos trae la lista de experiencia
  @GetMapping("/lista")
  public ResponseEntity<List<Experiencia>> list() {
    List <Experiencia> list = implementExperienciaService.list();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }


  //detail
  @GetMapping("/detail/{id}")
  public ResponseEntity<?> getById(@PathVariable("id") int id) {
    if (!implementExperienciaService.existsById(id))
      return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
    Experiencia experiencia = implementExperienciaService.getOne(id).get();
    return new ResponseEntity<>(experiencia, HttpStatus.OK);
  }




  //trae cualquier dato, una nueva experiencia
  @PostMapping("/create")
  public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoexp){
    if(StringUtils.isBlank(dtoexp.getNombreE()))
      return new ResponseEntity<>(new Mensaje("el nombre es obigatorio, POR FAVOR AGREGAR UNO"), HttpStatus.BAD_REQUEST);
    if(implementExperienciaService.existsByNombreE(dtoexp.getNombreE()))
      return new ResponseEntity<>(new Mensaje("la experiencia ya existe"), HttpStatus.BAD_REQUEST);

    Experiencia experiencia = new Experiencia(
            dtoexp.getNombreE(), dtoexp.getDescripcionE(), dtoexp.getImgE()
    );
    implementExperienciaService.save(experiencia);

    return new ResponseEntity<>(new Mensaje("Experiencia agregada"), HttpStatus.OK);
  }

  //corregimos o cambiamos datos
  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoexp) {
    //validamos si existe tal id
    if(!implementExperienciaService.existsById(id))
      return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

    //compara si dos experiencias son similares
    if(implementExperienciaService.existsByNombreE(dtoexp.getNombreE()) && implementExperienciaService.getByNombreE(dtoexp.getNombreE()).get().getId()!=id)
      return new ResponseEntity<>(new Mensaje("ya existe la experiencia"), HttpStatus.BAD_REQUEST);

    //el campo no puede estar vacio
    if(StringUtils.isBlank(dtoexp.getNombreE()))
      return new ResponseEntity<>(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);

    //replicar los 3 if con descripcion


    //arriba los filtros
    //si trae el dato correcto
    Experiencia experiencia = implementExperienciaService.getOne(id).get();
    experiencia.setNombreE(dtoexp.getNombreE());
    experiencia.setDescripcionE(dtoexp.getDescripcionE());
    experiencia.setImgE(dtoexp.getImgE());

    implementExperienciaService.save(experiencia);
      return new ResponseEntity<>(new Mensaje("Experiencia actualizada correctamente"), HttpStatus.OK);
  }


  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") int id) {
    //validamos si existe id
    if(!implementExperienciaService.existsById(id))
      return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);

    implementExperienciaService.delete(id);

    return new ResponseEntity<>(new Mensaje("Se elimino correctamente la experiencia"), HttpStatus.OK);
  }


}



