package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FillipeDiordService {
	
	public List<String> skills() {
		List<String> skills = new ArrayList<>();
        skills.add("strong push");
        skills.add("fire power");
        skills.add("laser vision");
        skills.add("steel body");
        skills.add("master lightsaber");
        skills.add("flying power");
        skills.add("telepathy");
        return skills;
	}

}
