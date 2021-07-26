package com.padwan.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RelacionamentoJedi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idMentor;
    private Integer idAprendiz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(Integer idMentor) {
        this.idMentor = idMentor;
    }

    public Integer getIdAprendiz() {
        return idAprendiz;
    }

    public void setIdAprendiz(Integer idAprendiz) {
        this.idAprendiz = idAprendiz;
    }
}
