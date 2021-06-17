package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItalloService {

    public List<String> skills(){
        List<String> skills = new ArrayList<>();
        skills.add("HTML");
        skills.add("Java");
        skills.add("Angular");
        skills.add("Hibernate");
        skills.add("Spring");
        skills.add("Java Script");
        skills.add("Sql");
        return skills; 
    }

}
