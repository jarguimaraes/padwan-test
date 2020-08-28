package com.padwan.test.service;

import com.padwan.test.dto.GenericoDTO;
import com.padwan.test.dto.ProcessDTO;
import org.springframework.stereotype.Service;

@Service
public class GenericoService {

    public ProcessDTO process(GenericoDTO generico){
        ProcessDTO processDTO = new ProcessDTO();
        processDTO.setClasseAbreviado(generico.getClasse().split(" ")[0]);
        processDTO.setPlanetAbreviado(generico.getPlanet().split(" ")[0]);
        Integer divisor = generico.getRanking() * 2;
        processDTO.setRankingMultiplicado(generico.getRanking()*124*612/divisor);
        return processDTO;
    }

}
