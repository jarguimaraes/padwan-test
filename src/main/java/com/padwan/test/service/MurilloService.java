package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MurilloService {

    public List<String> skills(){
        List<String> identification = new ArrayList<>();
        List<String> skills = new ArrayList<>();
        identification.add("Nome: Murillo Roseno");
        identification.add("Idade: 25 anos");
        identification.add("Formação Acadêmica: Bacharelado, Ciência da Computação");
		
        skills.add("PHP");
        skills.add("Bootstrap 4");
        skills.add("JQuery");
        skills.add("JavaScript");
        skills.add("Python");
        skills.add("Django");
        skills.add("Microsoft SQL Server");
        skills.add("MySQL");
        skills.add("PostgreSQL");
        identification.add("Principais Linguagens e Frameworks: " + skills);
        return identification;
    }

}
