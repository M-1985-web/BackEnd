package com.apportfolio.mmm.Service;


import com.apportfolio.mmm.Entity.SoftSkill;
import com.apportfolio.mmm.Repository.RSoftSkill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SSoftSkill {
    @Autowired
    RSoftSkill rSoftSkill;

    public List<SoftSkill> list(){
        return rSoftSkill.findAll();
    }

    public Optional<SoftSkill> buscarById(int id){
        return rSoftSkill.findById(id);
    }

    public void delete(int id){
        rSoftSkill.deleteById(id);
    }

    public void save(SoftSkill softSkill){
        rSoftSkill.save(softSkill);
    }

    public boolean existsById(int id){
        return rSoftSkill.existsById(id);
    }






}
