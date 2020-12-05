package com.padwan.test.controller;


import com.padwan.test.dto.JediDTO;
import com.padwan.test.repository.JediRepository;
import com.padwan.test.service.JediService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    
    @ResponseBody
    @RequestMapping(value = "/with-good-power", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> jedisWithGoodPower() {
        return new ResponseEntity(service.findJedisWithGoodPower(), HttpStatus.OK);
    }
    
    @ResponseBody
    @RequestMapping(value = "/masters-and-Apprentices", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> mastersAndApprentices() {
        return new ResponseEntity(service.findApprentices().toString(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/counts-jedis-status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> countsJedisByStatus() {
        return new ResponseEntity(service.countJedisByStatus(), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> incluirJedi(@RequestBody JediDTO jediDTO) {
        JediDTO novoJedi = service.incluir(jediDTO);
        return new ResponseEntity(novoJedi, HttpStatus.OK);
    }

}
