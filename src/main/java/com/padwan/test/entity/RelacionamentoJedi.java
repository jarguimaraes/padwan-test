package com.padwan.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.padwan.test.enums.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class RelacionamentoJedi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idMentor;
    private Integer idAprendiz;

}
