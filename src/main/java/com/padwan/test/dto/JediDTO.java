package com.padwan.test.dto;

import com.padwan.test.Enuns.Status;
import com.padwan.test.entity.Jedi;

public class JediDTO {

    private Integer id;
    private String nome;
    private Integer midichlorians;
    private Integer mentor;
    private Status status;

    public JediDTO() {

    }
    
    public JediDTO(Jedi jedi) {
        this.id = jedi.getId();
        this.nome = jedi.getNome();
        this.midichlorians = jedi.getMidichlorians();
        this.mentor = jedi.getMentor();
        this.status = jedi.getStatus();
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
    
}
