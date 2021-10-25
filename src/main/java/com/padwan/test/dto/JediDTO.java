package com.padwan.test.dto;

import com.padwan.test.entity.Jedi;
import com.padwan.test.enums.StatusEnum;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JediDTO {

    private Integer id;
    private String nome;
    private Integer midichlorians;
    private StatusEnum statusEnum;
    private Integer idMentor;

    public JediDTO(Jedi jedi) {
        this.id = jedi.getId();
        this.nome = jedi.getNome();
        this.midichlorians = jedi.getMidichlorians();
        this.statusEnum = jedi.getStatusEnum();
        this.idMentor = jedi.getIdMentor();
    }

}
