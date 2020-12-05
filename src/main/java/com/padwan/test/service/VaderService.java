package com.padwan.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VaderService {

  public List<String> skills() {
    List<String> skills = new ArrayList<>();
    skills.add("force push");
    skills.add("force pull");
    skills.add("force grip");
    skills.add("force choke");
    skills.add("master lightsaber");
    skills.add("master pilot");
    skills.add("telepathy");
    return skills;
  }

}
