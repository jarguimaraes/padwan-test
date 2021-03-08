package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarlosService {

    public List<String> skills() {
        List<String> skills = new ArrayList<>();
        skills.add("Proativo");
        skills.add("Esforçado");
        skills.add("Empatia");
        skills.add("Organizado");
        skills.add("Resiliente");
        return skills;
    }

}
