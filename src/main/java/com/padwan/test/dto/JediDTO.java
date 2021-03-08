package com.padwan.test.dto;

import com.padwan.test.entity.Jedi;

public class JediDTO {

    private Integer id;
    private String nome;
    private String status;
    private String mestre;
    private Float midichlorians;

    public JediDTO() {

    }

    public JediDTO(Jedi jedi) {
        this.id = jedi.getId();
        this.nome = jedi.getNome();
        this.status = jedi.getStatus();
        this.mestre = jedi.getMestre();
        this.midichlorians = jedi.getMidichlorians();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMestre() {
        return mestre;
    }

    public void setMestre(String mestre) {
        this.mestre = mestre;
    }

    public Float getMidichlorians() {
        return midichlorians;
    }

    public void setMidichlorians(Float midichlorians) {
        this.midichlorians = midichlorians;
    }
}
