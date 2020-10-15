package com.padwan.test.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padwan.test.service.WallysonService;

@RestController
@RequestMapping("/wallysonrichard")
public class WallysonController {

	@Autowired
	private WallysonService wallysonService;

	@GetMapping(value = "/skills", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> skills() {
		try {
			JSONObject json = new JSONObject();
			json.put("Wallyson Richard", wallysonService.skills());
			return ResponseEntity.ok(json.toString());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
