package com.padwan.test.controller;


import com.padwan.test.dto.CategoriaDTO;
import com.padwan.test.dto.JediDTO;
import com.padwan.test.dto.MestreEAprendizDTO;
import com.padwan.test.entity.Jedi;
import com.padwan.test.entity.RelacionamentoJedi;
import com.padwan.test.repository.JediRepository;
import com.padwan.test.service.JediService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jedi")
public class JediController {

    @Autowired
    private JediService service;

    @GetMapping(value = "")
    public ResponseEntity<Object> todos() {
        List<JediDTO> jedis = service.findAll();
        return new ResponseEntity(jedis, HttpStatus.OK);
    }


    @PostMapping(value = "")
    public ResponseEntity<Object> incluirJedi(@RequestBody JediDTO jediDTO) {
        JediDTO novoJedi = service.incluir(jediDTO);
        return new ResponseEntity(novoJedi, HttpStatus.OK);
    }

    @GetMapping(value = "/mestre-aprendiz")
    public ResponseEntity<Object> consultarMestreEAprendiz(){
        List<RelacionamentoJedi> mestreEAprendizDTOS = service.mestreEAprendiz();
        return new ResponseEntity(mestreEAprendizDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/midichlorians-maior9000")
    public ResponseEntity<Object>consultaMidichlorians(){
        List<JediDTO> jedi = service.consultarMidichlorians();
        return new ResponseEntity(jedi, HttpStatus.OK);
    }
    
    @ResponseBody
    @RequestMapping(value = "/quantidade-jedis", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> consultaPorCategoria(){
        JSONObject json = new JSONObject();
        json.put("Quantidade Jedi por categoria", service.consultarPorCategoria());
        return new ResponseEntity(json.toString(), HttpStatus.OK);
    }


}
