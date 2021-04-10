package com.padwan.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jedi")
public class Jedi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String status;
    private int mentor;
    private int midichlorians;
    
    public Jedi() {
    	
    }
    
    public Jedi(String nome, String status, int mentor, int midichlorians){
    	this.nome = nome;
    	this.status = status;
    	this.mentor = mentor;
    	this.midichlorians = midichlorians;
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

	public int getMentor() {
		return mentor;
	}

	public void setMentor(int mentor) {
		this.mentor = mentor;
	}

	public int getMidichlorians() {
		return midichlorians;
	}

	public void setMidichlorians(int midichlorians) {
		this.midichlorians = midichlorians;
	}   
    
}
