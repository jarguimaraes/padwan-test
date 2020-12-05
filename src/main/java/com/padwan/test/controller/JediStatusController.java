package com.padwan.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padwan.test.service.JediStatusService;

@RestController
@RequestMapping("/jedistatus")
public class JediStatusController {

  @Autowired
  private JediStatusService service;

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @GetMapping(path = "/jedisPorCategoria")
  public ResponseEntity jedisPorCategoria() {
    return new ResponseEntity(service.getJedisPorCategoria(), HttpStatus.OK);
  }

}
