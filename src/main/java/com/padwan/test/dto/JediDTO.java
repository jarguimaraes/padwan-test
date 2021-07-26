package com.padwan.test.dto;

import com.padwan.test.entity.Jedi;
import com.padwan.test.entity.RelacionamentoJedi;
import com.padwan.test.enums.StatusEnum;

public class JediDTO {

    private Integer id;
    private String nome;
    private Integer midichlorians;
    private StatusEnum statusEnum;
    private Integer idMentor;

    public JediDTO() {

    }

    public JediDTO(Jedi jedi) {
        this.id = jedi.getId();
        this.nome = jedi.getNome();
        this.midichlorians = jedi.getMidichlorians();
        this.statusEnum = jedi.getStatusEnum();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMidichlorians() {return midichlorians;}

    public void setMidichlorians(Integer midichlorians) {this.midichlorians = midichlorians;}

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    public Integer getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(Integer idMentor) {
        this.idMentor = idMentor;
    }
}
