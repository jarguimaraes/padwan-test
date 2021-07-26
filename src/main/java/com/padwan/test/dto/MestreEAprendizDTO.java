package com.padwan.test.dto;

import com.padwan.test.entity.Jedi;

import java.util.List;

public class MestreEAprendizDTO {

    private Jedi mestre;
    private List<Jedi> aprendizes;

    public MestreEAprendizDTO(){

    }

    public MestreEAprendizDTO(Jedi mestre, List<Jedi> aprendizes) {
        this.mestre = mestre;
        this.aprendizes = aprendizes;
    }

    public Jedi getMestre() {
        return mestre;
    }

    public void setMestre(Jedi mestre) {
        this.mestre = mestre;
    }

    public List<Jedi> getAprendizes() {
        return aprendizes;
    }

    public void setAprendizes(Jedi aprendiz) {
        this.aprendizes.add(aprendiz);
    }
}
