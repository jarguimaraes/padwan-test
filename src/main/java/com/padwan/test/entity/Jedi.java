package com.padwan.test.entity;

import com.padwan.test.enums.StatusEnum;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter@Setter
public class Jedi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer midichlorians;
    private StatusEnum statusEnum;
    private Integer idMentor;
    
}
