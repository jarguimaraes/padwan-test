package com.padwan.test.dto;

import com.padwan.test.entity.RelacionamentoJedi;

public class RelacionamentoJediDTO {
    private Integer id;
    private Integer idMentor;
    private Integer idAprendiz;

    public RelacionamentoJediDTO(){

    }

    public RelacionamentoJediDTO(RelacionamentoJedi relacionamentoJedi){
        this.id = relacionamentoJedi.getId();
        this.idMentor = relacionamentoJedi.getIdMentor();
        this.idAprendiz = relacionamentoJedi.getIdAprendiz();
    }

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
