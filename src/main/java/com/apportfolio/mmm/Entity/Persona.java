package com.apportfolio.mmm.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size(min = 1, max = 50, message = "nombre muy extenso, por favor agregar otro")
    private String nombre;
    @NotBlank
    @Size(min = 1, max = 50, message = " apellido muy extenso, por favor agregar otro")
    private String apellido;

    @NotBlank
    @Size(min = 30, max = 1000, message = "Acerca de excedio los caracteres permitidos")
    private String aboutMe;

    @NotBlank
    private String oficio;

    private String imgUrl;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Educacion> educacionList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Experiencia> experienciaList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Skills> skillsList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<SoftSkill> softSkillList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<NewProyec> newProyecList;

    //constructores

    public Persona() {
    }

    public Persona(@NotBlank String nombre, @NotBlank String apellido, String imgUrl, @NotBlank String aboutMe,
                   @NotBlank String oficio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imgUrl = imgUrl;
        this.aboutMe = aboutMe;
        this.oficio = oficio;
    }
    //setter and getters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Educacion> getEducacionList() {
        return educacionList;
    }

    public void setEducacionList(List<Educacion> educacionList) {
        this.educacionList = educacionList;
    }

    public List<Experiencia> getExperienciaList() {
        return experienciaList;
    }

    public void setExperienciaList(List<Experiencia> experienciaList) {
        this.experienciaList = experienciaList;
    }

    public List<Skills> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<Skills> skillsList) {
        this.skillsList = skillsList;
    }

    public List<SoftSkill> getSoftSkillList() {
        return softSkillList;
    }

    public void setSoftSkillList(List<SoftSkill> softSkillList) {
        this.softSkillList = softSkillList;
    }

    public List<NewProyec> getNewProyecList() {
        return newProyecList;
    }

    public void setNewProyecList(List<NewProyec> newProyecList) {
        this.newProyecList = newProyecList;
    }
}
