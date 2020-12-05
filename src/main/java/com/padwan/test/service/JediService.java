package com.padwan.test.service;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.entity.Jedi;
import com.padwan.test.repository.JediRepository;
import com.padwan.test.repository.groupStatus;

import org.json.JSONArray;
import org.json.JSONObject;
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
    
    public List<JediDTO> findJedisWithGoodPower(){
        List<Jedi> jedis = repository.findAllJediWithGoodPower();
        List<JediDTO> listJedis = new ArrayList<>();
        jedis.forEach(jedi -> listJedis.add(new JediDTO(jedi)));
        return listJedis;    	
    }
    
    public JSONArray findApprentices(){
        List<Jedi> jedis = repository.findAllApprentices();
        
        JSONObject json = new JSONObject();        
        JSONArray jsonList = new JSONArray();
        jedis.forEach(jedi ->{ 
        	Jedi mestreJedi = repository.findById(jedi.getMestreJedi()).orElse(null);
        	json.put("Mestre", mestreJedi.getNome());
        	json.put("Aprendiz", jedi.getNome());
        	
        	jsonList.put(json);
        });
        
        return jsonList;
    }

    public List<groupStatus> countJedisByStatus() {
    	return repository.countsJedisByStatus();
    }
    
    public JediDTO incluir(JediDTO jediDTO) {
        Jedi jedi = new Jedi();
        
        if (jediDTO.getMestreJedi() != null) {
	        Jedi mestreJedi = repository.findById(jediDTO.getMestreJedi()).orElse(null); 
	    	
	        if((mestreJedi != null) && (mestreJedi.getStatus() == enuns.Status.MESTRE_JEDI)) {
	        	jedi.setMestreJedi(mestreJedi.getId());
	        }
        }
        
        jedi.setId(jediDTO.getId());
        jedi.setNome(jediDTO.getNome());
    	jedi.setStatus(jediDTO.getStatus());
        jedi.setMidichlorians(jediDTO.getMidichlorians());
        
        return new JediDTO(repository.save(jedi));  
    }
}
