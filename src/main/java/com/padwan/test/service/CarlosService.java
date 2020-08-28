package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarlosService {

    public List<String> skills(){
        List<String> skills = new ArrayList<>();
        skills.add("git");
        skills.add("scrum");
        return skills;
    }

}
