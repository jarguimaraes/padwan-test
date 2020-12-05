package com.padwan.test.dto;

import com.padwan.test.entity.Jedi;

import enuns.Status;

public class JediDTO {

    private Integer id;
    private String nome;
    private Status status;
    private Integer midichlorians;
    private Integer mestreJedi;

	public JediDTO() {

    }

    public JediDTO(Jedi jedi) {
        this.id = jedi.getId();
        this.nome = jedi.getNome();
        this.status = jedi.getStatus();
        this.midichlorians = jedi.getMidichlorians();
        this.mestreJedi = jedi.getMestreJedi();
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
    

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getMidichlorians() {
		return midichlorians;
	}

	public void setMidichlorians(Integer midichlorians) {
		this.midichlorians = midichlorians;
	}
	
    public Integer getMestreJedi() {
		return mestreJedi;
	}

	public void setMestreJedi(Integer mestreJedi) {
		this.mestreJedi = mestreJedi;
	}


}
