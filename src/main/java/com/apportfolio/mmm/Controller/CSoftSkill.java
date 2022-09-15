package com.apportfolio.mmm.Controller;

//internas
import com.apportfolio.mmm.Dto.dtoSoftSkill;
import com.apportfolio.mmm.Entity.SoftSkill;
import com.apportfolio.mmm.Security.Controller.Mensaje;
import com.apportfolio.mmm.Service.SSoftSkill;

//externas
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

//* por las dudas agrego cada una sin que me agrupe
//tudo con el asterisco
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;

@RestController
@RequestMapping("softskill")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://frontendmmm.web.app")


public class CSoftSkill {
    @Autowired
    SSoftSkill sSoftSkill;

    @GetMapping("/lista")
    public ResponseEntity<List<SoftSkill>> list() {
        List<SoftSkill> list = sSoftSkill.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //modifique SoftSkill por ?
    //agregue <> para que me tome el ResponseEntity<>
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id")int id){
        if(!sSoftSkill.existsById(id)){
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        SoftSkill skill = sSoftSkill.buscarById(id).get();
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!sSoftSkill.existsById(id)){
            return new ResponseEntity<>(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        sSoftSkill.delete(id);
        return new ResponseEntity<>(new Mensaje("La skill fue eliminada."), HttpStatus.OK);
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSoftSkill dtoskill){
        if(StringUtils.isBlank(dtoskill.getNombreS())){
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        SoftSkill skill = new SoftSkill(dtoskill.getNombreS(),dtoskill.getCapacidadS(),dtoskill.getTipoS());
        sSoftSkill.save(skill);
        return new ResponseEntity<>(new Mensaje("la skill fue agregada correctamente"), HttpStatus.OK);
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoSoftSkill dtoskill){
        if(!sSoftSkill.existsById(id)){
            return new ResponseEntity<>(new Mensaje("No Existe esa Skill"), HttpStatus.BAD_REQUEST);
        }


        if(StringUtils.isBlank(dtoskill.getNombreS())){
            return new ResponseEntity<>(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        SoftSkill skill =  sSoftSkill.buscarById(id).get();
        skill.setNombreS(dtoskill.getNombreS());
        skill.setCapacidadS(dtoskill.getCapacidadS());
        skill.setTipoS(dtoskill.getTipoS());
        sSoftSkill.save(skill);
        return new ResponseEntity<>(new Mensaje("La Skill fue actualizada con exito"), HttpStatus.OK);
    }






}
