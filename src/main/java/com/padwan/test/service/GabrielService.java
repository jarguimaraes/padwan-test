package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GabrielService {

    public List<String> skills(){
        List<String> skills = new ArrayList<>();
        skills.add("Concentrated Fury");
        skills.add("Saber Throw");
        skills.add("Hang with Force");
        skills.add("Being Luke's father");
        return skills;
    }

}
