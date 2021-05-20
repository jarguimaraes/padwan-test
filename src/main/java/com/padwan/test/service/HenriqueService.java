package com.padwan.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HenriqueService {

	public List<String> skills(){
		
		List<String > skills = new ArrayList<>();
		
		skills.add("Ama trabalhar em equipe");
		skills.add("Resolver poblemas");
		skills.add("Criativo");
		skills.add("Idependente");
		skills.add("Super ajuda ao proximo");
		skills.add("Autoditada");
		
		return skills;
		
	}
	
}
