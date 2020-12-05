package com.padwan.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.padwan.test.dto.GenericoDTO;
import com.padwan.test.service.GenericoService;

@RestController
@RequestMapping("/generic-post")
public class GenericoController {

  private GenericoService genericoService;

  @Autowired
  public GenericoController(GenericoService genericoService) {
    this.genericoService = genericoService;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @ResponseBody
  @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity process(@RequestBody GenericoDTO json) {
    try {
      return new ResponseEntity(genericoService.process(json), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity("erro ao processar o generico", HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

}
