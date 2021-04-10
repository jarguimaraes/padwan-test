package com.padwan.test.service;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.entity.Jedi;
import com.padwan.test.repository.JediRepository;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JediService {

    @Autowired
    private JediRepository repository;

    public List<JediDTO> findAll() {
        List<Jedi> jedis = repository.findAll();
        List<JediDTO> listJedis = new ArrayList<>();
        jedis.forEach(it -> listJedis.add(new JediDTO(it)));
        return listJedis;
    }

    public JediDTO incluir(JediDTO jediDTO) {
    	//List<Jedi> mentor = repository.findByJedi(jediDTO.getMentor());
    	
        Jedi jedi = new Jedi();
        jedi.setId(jediDTO.getId());
        jedi.setNome(jediDTO.getNome());
        jedi.setStatus(jediDTO.getStatus());
        //jedi.setMentor(((JediDTO) mentor).getId());
        jedi.setMidichlorians(jediDTO.getMidichlorians());
        
        repository.save(jedi);
        
        return new JediDTO(repository.save(jedi));
    }
    
    
  /*public List<JediDTO> findJediAndAprenticeByStatus(){
	  
	  List<Jedi> jedis = repository.findAll();
      List<JediDTO> listJediAndAprentice = new ArrayList<>();
      JediDTO.this.getStatus()
      return listJediAndAprentice;
  }
  
  public List<JediDTO> findJediByMidichloriansAndStatus(){
	  
  }
  public List<JediDTO> countStatus(){
	  
  }*/
    
}
