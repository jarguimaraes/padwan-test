package com.padwan.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EleonardoService {

  public List<String> skills() {
    // Yes, I'm stronger than Darth Vader
    List<String> skills = new ArrayList<>();
    skills.add("Force Push");
    skills.add("Force Pull");
    skills.add("Force Grip");
    skills.add("Force Vision");
    skills.add("Master Lightsaber");
    skills.add("Master Pilot");
    skills.add("Force Sight");
    skills.add("Force Listening");
    skills.add("Hibernation Trance");
    skills.add("Tapas");
    skills.add("Thought Shield");
    return skills;
  }

}
