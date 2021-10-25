package com.padwan.test.dto;

import com.padwan.test.entity.RelacionamentoJedi;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RelacionamentoJediDTO {
    private Integer id;
    private Integer idMentor;
    private Integer idAprendiz;

    
    public RelacionamentoJediDTO(RelacionamentoJedi relacionamentoJedi){
        this.id = relacionamentoJedi.getId();
        this.idMentor = relacionamentoJedi.getIdMentor();
        this.idAprendiz = relacionamentoJedi.getIdAprendiz();
    }
}
