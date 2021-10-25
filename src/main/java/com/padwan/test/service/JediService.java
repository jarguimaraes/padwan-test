package com.padwan.test.service;

import com.padwan.test.dto.CategoriaDTO;
import com.padwan.test.dto.JediDTO;
import com.padwan.test.dto.MestreEAprendizDTO;
import com.padwan.test.dto.RelacionamentoJediDTO;
import com.padwan.test.entity.Jedi;
import com.padwan.test.entity.RelacionamentoJedi;
import com.padwan.test.enums.StatusEnum;
import com.padwan.test.repository.JediRepository;
import com.padwan.test.repository.RelacionamentoJediRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class JediService {

    @Autowired
    private JediRepository repository;

    @Autowired
    private RelacionamentoJediRepository relacionamentoJediRepository;

    public List<JediDTO> findAll() {
        List<Jedi> jedis = repository.findAll();
        List<JediDTO> listJedis = new ArrayList<>();
        jedis.forEach(it -> listJedis.add(new JediDTO(it)));
        return listJedis;
    }

    public JediDTO incluir(JediDTO jediDTO) {
        Jedi jedi = new Jedi();
        jedi.setId(jediDTO.getId());
        jedi.setNome(jediDTO.getNome());
        jedi.setStatusEnum(jediDTO.getStatusEnum());
        jedi.setMidichlorians(jediDTO.getMidichlorians());
        jedi.setIdMentor(jediDTO.getIdMentor());
        JediDTO jediDTO1 = new JediDTO(repository.save(jedi));
        if (jediDTO.getIdMentor() != null && jediDTO.getIdMentor() != 0){
            RelacionamentoJedi relacionamentoJedi = new RelacionamentoJedi();
            relacionamentoJedi.setIdMentor(jediDTO.getIdMentor());
            relacionamentoJedi.setIdAprendiz(jediDTO1.getId());
            RelacionamentoJediDTO relacionamentoJediDTO = new RelacionamentoJediDTO(relacionamentoJediRepository.save(relacionamentoJedi));
            jediDTO1.setIdMentor(relacionamentoJediDTO.getIdMentor());
        }
        return jediDTO1;
    }
       
    public List<RelacionamentoJedi> mestreEAprendiz(){
        return relacionamentoJediRepository.consultarMestreEAprendiz();
     }
   
    public List<JediDTO> consultarMidichlorians(){
    	List<JediDTO> jediList = repository.consultarMidichlorians().stream().map(e -> {
    		JediDTO dto = new JediDTO();
    		dto.setId(e.getId());
    		dto.setNome(e.getNome());
    		dto.setMidichlorians(e.getMidichlorians());
    		dto.setStatusEnum(e.getStatusEnum());
    		dto.setIdMentor(e.getIdMentor());
    		
    		return dto;
    		
    	}).collect(Collectors.toList());
    	
    	return jediList;
    }
    
    
    public List<CategoriaDTO> consultarPorCategoria(){
    	List<CategoriaDTO> catList = repository.consultarPorCategoria().stream().map(e -> {
    		CategoriaDTO dto = new CategoriaDTO();
    		dto.setCategoria(e.getCategoria());
    		dto.setQuantidade(e.getQuantidade());
    		
    		return dto;
    	}).collect(Collectors.toList());
    	
    	return catList;
    }
    

}
