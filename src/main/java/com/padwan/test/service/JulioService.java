package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JulioService {

    public List<String> skills(){
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Spring Boot");
        skills.add("Hibernate");
        skills.add("SQL");
        return skills;
    }

}
