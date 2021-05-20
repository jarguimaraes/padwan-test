package com.padwan.test.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.padwan.test.service.HenriqueService;

@RestController
@RequestMapping("/henrique")
public class HenriqueController {

	@Autowired
	private HenriqueService service;
	
	    @ResponseBody
	    @RequestMapping(value = "/skills", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> skills() {  
	    	 try {
	             JSONObject json = new JSONObject();
	             json.put("Henrique Santos", service.skills());
	             return new ResponseEntity(json.toString(), HttpStatus.OK);
	         } catch (Exception e) {
	             return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	         }
	  }
	
	
}
