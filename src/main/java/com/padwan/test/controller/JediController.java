package com.padwan.test.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.padwan.test.dto.JediDTO;
import com.padwan.test.entity.Jedi;
import com.padwan.test.service.JediService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jedi")
public class JediController {

    @Autowired
    private JediService service;

    @GetMapping(value = "")
    public ResponseEntity<Object> todos() {
        List<JediDTO> jedis = service.findAll();
        return new ResponseEntity<Object>(jedis, HttpStatus.OK);
    }

    @GetMapping("/jedi/mestreJedis")
    public @ResponseBody Iterable<JediDTO> mestreJedis(@PathVariable String mestre, @PathVariable String nome,
            Mode model) {

        Iterable<Jedi> listaMestresJedis = service.findByMestre(mestre, nome);

        return (Iterable<JediDTO>) new ResponseEntity<Object>(listaMestresJedis, HttpStatus.OK);

    }

    @GetMapping("/jedi/midichlorians")
    public @ResponseBody Iterable<JediDTO> Midichlorians(@PathVariable String nome, Integer midichkirians, Mode model) {

        Iterable<Jedi> Midichlorians = service.findByMidichlorians(nome, midichkirians);

        return (Iterable<JediDTO>) new ResponseEntity<Object>(Midichlorians, HttpStatus.OK);

    }

    @GetMapping("/jedi/categoria")
    public @ResponseBody Iterable<JediDTO> findByStatus(@PathVariable String status, Mode model) {

        Iterable<Jedi> Status = service.findByStatus(status);

        return (Iterable<JediDTO>) new ResponseEntity<Object>(Status, HttpStatus.OK);

    }

    @PostMapping(value = "")
    public ResponseEntity<Object> incluirJedi(@RequestBody JediDTO jediDTO) {
        JediDTO novoJedi = service.incluir(jediDTO);
        return new ResponseEntity<Object>(novoJedi, HttpStatus.OK);
    }

}
