package com.padwan.test.controller;


import com.padwan.test.dto.JediDTO;
import com.padwan.test.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    /*@GetMapping(value = "/{midichlorians}")
    public Jedi listaJedi(@PathVarialble(value="midichlorians")) {
                return new jediRepository.findById(midichlorians);
    }*/

    @PostMapping(value = "")
    public ResponseEntity<Object> incluirJedi(@RequestBody JediDTO jediDTO) {
        JediDTO novoJedi = service.incluir(jediDTO);
        return new ResponseEntity(novoJedi, HttpStatus.OK);
    }

}
