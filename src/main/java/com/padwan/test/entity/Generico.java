package com.padwan.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Generico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String planet;
    private String classe;
    private String ranking;

    public String getPlanet() {
        return planet;
    }

    public void setpPlanet(String planet) {
        this.planet = planet;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}
