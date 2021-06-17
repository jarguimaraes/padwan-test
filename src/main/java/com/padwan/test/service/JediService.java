package com.padwan.test.service;

import com.padwan.test.Enuns.StatusEnum;
import com.padwan.test.dto.JediDTO;
import com.padwan.test.entity.Jedi;
import com.padwan.test.repository.JediRepository;
import com.padwan.test.repository.StatusRepository;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

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
		Jedi jedi = new Jedi();

		if (jediDTO.getMentor() != null) {
			Jedi mentor = repository.findById(jediDTO.getMentor())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "mestre nÃ£o encontrado"));

			if ((mentor != null) && (mentor.getStatus() == StatusEnum.MESTRE_JEDI)) {
				jedi.setMentor(mentor.getId());
			}
		}

		jedi.setId(jediDTO.getId());
		jedi.setNome(jediDTO.getNome());
		jedi.setMidichlorians(jediDTO.getMidichlorians());
		jedi.setStatus(jediDTO.getStatus());
		return new JediDTO(repository.save(jedi));
	}
    

	public JSONArray findAprendizes() {
		List<Jedi> jedis = repository.findAllAprendizes();

		JSONObject obj = new JSONObject();
		JSONArray listObj = new JSONArray();
		
		jedis.forEach(jedi -> {
			Jedi mestreJedi = repository.findById(jedi.getMentor())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "mestre não encontrado"));
			obj.put("Mestre", mestreJedi.getNome());
			obj.put("Aprendiz", jedi.getNome());

			listObj.put(obj);
		});

		return listObj;
	}
	
    public List<StatusRepository> jediByStatus() {
    	return repository.countStatus();
    }

	public List<JediDTO> FindPoderMaximo() {

		List<Jedi> jedi = repository.findAllPowerMAx();
		List<JediDTO> jediDTO = new ArrayList<>();

		jedi.forEach(jedis -> jediDTO.add(new JediDTO(jedis)));
		return jediDTO;

	}


}
