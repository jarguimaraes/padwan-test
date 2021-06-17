package com.padwan.test.dto;

import com.padwan.test.Enuns.StatusEnum;
import com.padwan.test.entity.Jedi;

public class JediDTO {

    private Integer id;
    private String nome;
    private Integer midichlorians;
    private Integer mentor;
    private StatusEnum statusEnum;

    public JediDTO() {

    }
    
	public JediDTO(Jedi jedi) {
        this.id = jedi.getId();
        this.nome = jedi.getNome();
        this.midichlorians = jedi.getMidichlorians();
        this.mentor = jedi.getMentor();
        this.statusEnum = jedi.getStatus();
    }
    
    public StatusEnum getStatusEnum() {
		return statusEnum;
	}


	public void setStatusEnum(StatusEnum statusEnum) {
		this.statusEnum = statusEnum;
	}


	public void setId(Integer id) {
		this.id = id;
	}

    public Integer getId() {
        return id;
    }
    
	public String getNome() {
		return nome;
	}
	
    public void setNome(String nome) {
        this.nome = nome;
    }

	public Integer getMidichlorians() {
		return midichlorians;
	}

	public void setMidichlorians(Integer midichlorians) {
		this.midichlorians = midichlorians;
	}

	public Integer getMentor() {
		return mentor;
	}

	public void setMentor(Integer mentor) {
		this.mentor = mentor;
	}

	public StatusEnum getStatus() {
		return statusEnum;
	}

	public void setStatus(StatusEnum statusEnum) {
		this.statusEnum = statusEnum;
	}

}
