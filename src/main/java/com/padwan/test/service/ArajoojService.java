package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArajoojService {

    public List<String> skills(){
        List<String> skills = new ArrayList<>();

        skills.add("Carisma +20");
        skills.add("Altura -10");
        skills.add("Escovador de Codigo +8000");
        skills.add("Aprendizado STACKOVERFLOW");

        return skills;
    }

}
