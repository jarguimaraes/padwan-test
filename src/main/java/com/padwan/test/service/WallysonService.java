package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WallysonService {

	public List<String> skills() {
		List<String> skills = new ArrayList<>();
		skills.add("HTML");
		skills.add("CSS");
		skills.add("Javascript");
		skills.add("Node");
		skills.add("React");
		skills.add("Java");
		skills.add("Springboot");
		skills.add("Persistente");
		skills.add("Dedicado");
		skills.add("Esforçado");
		return skills;
	}

}
