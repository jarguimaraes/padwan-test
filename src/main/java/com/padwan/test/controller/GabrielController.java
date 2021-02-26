package com.padwan.test.controller;

import com.padwan.test.dto.GenericoDTO;
import com.padwan.test.service.GabrielService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/gabriel")
public class GabrielController {
	private GabrielService gabrielService;
	
    @Autowired
    public GabrielController(GabrielService gabrielService){
    	this.gabrielService = gabrielService;
    }

    @ResponseBody
    @RequestMapping(value = "/skills", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> skills() {
        try {
            JSONObject json = new JSONObject();
            json.put("Gabriel Santos", gabrielService.skills());
            return new ResponseEntity(json.toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
