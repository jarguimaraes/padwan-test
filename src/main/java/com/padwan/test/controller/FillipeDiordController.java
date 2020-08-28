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

import com.padwan.test.service.FillipeDiordService;

@RestController
@RequestMapping("/fillipediord")
public class FillipeDiordController {
	
	private FillipeDiordService fillipeDiordService;
	
	@Autowired
	public FillipeDiordController(FillipeDiordService fillipeDiordService) {
		this.fillipeDiordService = fillipeDiordService;
	}

	@ResponseBody
	@RequestMapping(value = "/skills", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> skills() {
		try {
			JSONObject json = new JSONObject();
			json.put("Fillipe Diord", fillipeDiordService.skills());
			return new ResponseEntity<Object>(json.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
