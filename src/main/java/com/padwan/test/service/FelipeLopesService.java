package com.padwan.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FelipeLopesService {
	
	 public List<String> skills(){
	        List<String> skills = new ArrayList<>();
	        skills.add("aumento de salário kk");
	        skills.add("hyper dedicação");
	        skills.add("Bom gosto por também gostar de StarWars");
	        skills.add("alto consumo de café");
	        skills.add("produtividade");
	        return skills;
	    }



}
