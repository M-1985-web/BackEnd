package com.apportfolio.mmm.Service;


import com.apportfolio.mmm.Entity.NewProyec;
import com.apportfolio.mmm.Repository.ReProyec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class SProyec {
    @Autowired
    ReProyec reProyec;

    public List<NewProyec> list(){
        return reProyec.findAll();
    }

    public Optional<NewProyec> buscarById(int id){
        return reProyec.findById(id);
    }
    public Optional<NewProyec>buscarByTitulo(String titulo){
        return reProyec.findByTitulo(titulo);
    }
    public void guardar(NewProyec proyec){
        reProyec.save(proyec);
    }
    public void delete(int id){
        reProyec.deleteById(id);
    }
    public boolean existsById(int id){
        return reProyec.existsById(id);
    }
    public boolean existsByTitulo(String titulo){
        return reProyec.existsByTitulo(titulo);
    }
}
