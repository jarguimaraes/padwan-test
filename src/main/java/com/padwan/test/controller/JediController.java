package com.padwan.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.service.JediService;

@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequestMapping("/jedi")
public class JediController {

  @Autowired
  private JediService service;

  @GetMapping(value = "")
  public ResponseEntity<Object> todos() {
    return new ResponseEntity(service.findAll(), HttpStatus.OK);
  }

  @PostMapping(value = "")
  public ResponseEntity<Object> incluirJedi(@RequestBody JediDTO jediDTO) {
    try {
      return new ResponseEntity(service.incluir(jediDTO), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(path = "/jedisMaiorQue")
  public ResponseEntity jedisMaiorQue() {
    return new ResponseEntity(service.getJediMidichloriansMaiorQue(), HttpStatus.OK);
  }

  @GetMapping(path = "/jedisMentores")
  public ResponseEntity jedisMentores() {
    return new ResponseEntity(service.getJedisMentores(), HttpStatus.OK);
  }
}
