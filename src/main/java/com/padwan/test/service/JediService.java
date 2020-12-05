package com.padwan.test.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.entity.Jedi;
import com.padwan.test.repository.JediRepository;
import com.padwan.test.repository.JediStatusRepository;

@Service
public class JediService {

  @Autowired
  private JediRepository jediRepository;

  @Autowired
  private JediStatusRepository jediStatusRepository;

  public List<JediDTO> findAll() {
    List<Jedi> jedis = jediRepository.findAll();
    List<JediDTO> listJedis = new ArrayList<>();
    jedis.forEach(it -> listJedis.add(new JediDTO(it)));
    return listJedis;
  }

  public List<JediDTO> getJediMidichloriansMaiorQue() {
    List<Jedi> jedis = jediRepository.findJediMidichloriansMaiorQue();
    List<JediDTO> listJedis = new ArrayList<>();
    jedis.forEach(jedi -> listJedis.add(new JediDTO(jedi)));
    return listJedis;
  }

  public JediDTO incluir(JediDTO jediDTO) throws Exception {
    if(jediDTO.getNome().isBlank())
      throw new Exception("Opa, o Jedi precisa ter um nome, não acha?");
    
    if(jediDTO.getStatus() == null)
      throw new Exception("O que acha de informar o status desse Jedi, hein?");

    // Validando se status é válido
    if (Optional.empty().equals(jediStatusRepository.findById(jediDTO.getStatus().getId())))
      throw new Exception("Esse Status não existe, ou não foi criado ainda!");
    
    if(jediDTO.getMidichlorians() <= 0)
      throw new Exception("Na na ni na não! Ninguém é tão fraco que não tenha Midichlorians! Fala pra esse Jedi deixar de ser modesto!");

    // Validando se o Mentor Jedi passado existe
    Optional<Jedi> mentorJedi = jediRepository.findById(jediDTO.getJediMentorId());
    if (mentorJedi.isEmpty())
      throw new Exception("O Jedi Mentor informado não existe! Não consigo crer que temos outro caso de um autodidata...");

    // Validando se o Mentor Jedi é um Mestre Jedi - Apenas mestres Jedi podem ser
    // mentores
    if (mentorJedi.get().getStatus().getId() != jediStatusRepository.getMestreJediId())
      throw new Exception("O Jedi Mentor informado não é um Mestre Jedi! Quem é ele na fila? Oxe!");

    Jedi jedi = new Jedi();
    jedi.setId(jediDTO.getId());
    jedi.setNome(jediDTO.getNome());
    jedi.setStatus(jediDTO.getStatus());
    jedi.setJediMentorId(jediDTO.getJediMentorId());
    jedi.setMidichlorians(jediDTO.getMidichlorians());
    return new JediDTO(jediRepository.save(jedi));
  }

  public String getJedisMentores() {
    String[] jedisMentores = jediRepository.getJedisMentores();

    JSONObject json = new JSONObject();
    List<JSONObject> objects = new ArrayList<>();

    Arrays.asList(jedisMentores).forEach(row -> {
      JSONObject item = new JSONObject();
      String[] values = row.split(",");

      item.put("mentor", values[0]);
      item.put("jedi", values[1]);
      item.put("status", values[2]);

      objects.add(item);
    });

    json.accumulate("result", objects);

    return json.toString();
  }
}
