package com.padwan.test.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_JEDI")
public class Jedi implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String status;
    private String mentor;
    private Integer midichlorians;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMentor() {
		return mentor;
	}

	public void setMentor(String mentor) {
		this.mentor = mentor;
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
	
}
