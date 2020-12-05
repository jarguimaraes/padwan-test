package com.padwan.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import enuns.Status;

@Entity
public class Jedi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer midichlorians;
    
    @Column(nullable = false)
    private Status status;
    
    @Column(unique=true)
    private Integer mestreJedi;
    		
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

	public Integer getMestreJedi() {
		return mestreJedi;
	}

	public void setMestreJedi(Integer mestreJedi) {
		this.mestreJedi = mestreJedi;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
