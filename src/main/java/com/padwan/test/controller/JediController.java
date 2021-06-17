package com.padwan.test.controller;


import com.padwan.test.dto.JediDTO;
import com.padwan.test.service.JediService;
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


    @PostMapping(value = "")
    public ResponseEntity<Object> incluirJedi(@RequestBody JediDTO jediDTO) {
        JediDTO objRetorno = service.incluir(jediDTO);
        
        return new ResponseEntity(objRetorno, HttpStatus.OK);
    }
    

    @ResponseBody
    @RequestMapping(value = "/podermax", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> JediMaxPower() {
    	
        return new ResponseEntity(service.FindPoderMaximo(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/aprendizes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> aprendizes() {
    	
        return new ResponseEntity(service.findAprendizes().toString(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/jedistatus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> countsJedisByStatus() {
    	
        return new ResponseEntity(service.jediByStatus(), HttpStatus.OK);
    }


}
