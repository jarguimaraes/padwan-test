package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedroService {

    public List<String> skills(){
        List<String> skills = new ArrayList<>();
        skills.add("Autodidata");
        skills.add("Dedicação +999");
        skills.add("Benção da paciencia de jó");
        return skills;
    }

}
