package com.padwan.test.controller;

import com.padwan.test.service.LucasRezendeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lucasrezende")
public class LucasRezendeController {

    private final LucasRezendeService lucasRezendeService;

    @Autowired
    public LucasRezendeController(LucasRezendeService lucasRezendeService) {
        this.lucasRezendeService = lucasRezendeService;
    }

    @GetMapping(value = "/skills", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> skills() {
        try {
            JSONObject json = new JSONObject();
            json.put("Lucas da Silva Rezende", lucasRezendeService.skills());
            return new ResponseEntity(json.toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
