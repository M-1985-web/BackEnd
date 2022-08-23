package com.apportfolio.mmm.Controller;


import com.apportfolio.mmm.Dto.DtoEducacion;
import com.apportfolio.mmm.Entity.Educacion;
import com.apportfolio.mmm.Security.Controller.Mensaje;
import com.apportfolio.mmm.Service.ImplementEducacionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")

public class EducacionController {

  @Autowired
  ImplementEducacionService implementEducacionService;

  @GetMapping("/lista")
  public ResponseEntity<List<Educacion>> list(){
    List<Educacion> list = implementEducacionService.list();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }


  @GetMapping("/detail/{id}")
  public ResponseEntity<?> getById(@PathVariable("id")int id){
    if(!implementEducacionService.existsById(id)){
      return new ResponseEntity<>(new Mensaje("No existe el ID, indiquelo nuevamente"), HttpStatus.BAD_REQUEST);
    }
    Educacion educacion = implementEducacionService.getOne(id).get();
    return new ResponseEntity<>(educacion, HttpStatus.OK);
  }



  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") int id){
    //validaciones
    if(!implementEducacionService.existsById(id)){
      return new ResponseEntity<>(new Mensaje("No existe el ID, indiquelo nuevamente"), HttpStatus.NOT_FOUND);
    }
    implementEducacionService.delete(id);
    return new ResponseEntity<>(new Mensaje("Educacion eliminada exitosamente"), HttpStatus.OK);
  }




  @PostMapping("/create")
  public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEducacion){
    //isBlank validacion de que el campo no este blanco
    if(StringUtils.isBlank(dtoEducacion.getNombreEdu())){
      return new ResponseEntity<>(new Mensaje("El nombre es obligatorio, por favor agregarlo"), HttpStatus.BAD_REQUEST);
    }
    if(implementEducacionService.existsByNombreEdu(dtoEducacion.getNombreEdu())){
      return new ResponseEntity<>(new Mensaje("Ese nombre ya existe, indique otro"), HttpStatus.BAD_REQUEST);
    }

    Educacion educacion = new Educacion(
      dtoEducacion.getNombreEdu(), dtoEducacion.getDescripcionEdu()
    );
    //aca entra el nombre y la descripcion nueva
    implementEducacionService.save(educacion);
    return new ResponseEntity<>(new Mensaje("Educacion creada con exito"), HttpStatus.OK);

  }



  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion){
    if(!implementEducacionService.existsById(id)){
      return new ResponseEntity<>(new Mensaje("No existe el ID, indique otro"), HttpStatus.NOT_FOUND);
    }
    if(implementEducacionService.existsByNombreEdu(dtoEducacion.getNombreEdu()) && implementEducacionService.getByNombreEdu(dtoEducacion.getNombreEdu()).get().getId() != id){
      return new ResponseEntity<>(new Mensaje("Ese nombre ya existe, indique otro"), HttpStatus.BAD_REQUEST);
    }
    if(StringUtils.isBlank(dtoEducacion.getNombreEdu())){
      return new ResponseEntity<>(new Mensaje("El campo no puede estar vacio, por favor llenar campos"), HttpStatus.BAD_REQUEST);
    }

    //replicar los 3 if con descripcion

    Educacion educacion = implementEducacionService.getOne(id).get();
    //aca actualizamos los parametros ingresados
    educacion.setNombreEdu(dtoEducacion.getNombreEdu());
    educacion.setDescripcionEdu(dtoEducacion.getDescripcionEdu());

    implementEducacionService.save(educacion);
    return new ResponseEntity<>(new Mensaje("Educacion actualizada con exito"), HttpStatus.OK);
  }



}
