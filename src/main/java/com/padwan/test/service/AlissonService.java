package com.padwan.test.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service

public class AlissonService {
    
    public List<String> skills(){
        List<String> features = new ArrayList<>();
        List<String> skillsPersonal = new ArrayList<>();
        List<String> skillsTechniques = new ArrayList<>();
        
        features.add("Nome: Alisson Melo dos Santos");
        features.add("Idade: 25 anos");
        features.add("Contato: (63) 9 9996-9900");
        
        skillsPersonal.add("Humildade");
        skillsPersonal.add("Honestidade");
        skillsPersonal.add("Otimismo");
        skillsPersonal.add("Dedicação");
        skillsPersonal.add("Paciência");
        
        skillsTechniques.add("PHP");
        skillsTechniques.add("JavaScript");
        skillsTechniques.add("JQuery");
        skillsTechniques.add("HTML");
        skillsTechniques.add("CSS");
        skillsTechniques.add("Java");
        skillsTechniques.add("SQL Server");
        skillsTechniques.add("MySql");
        
        features.add("Pessoais: " + skillsPersonal);
        features.add("Técnicas: " + skillsTechniques);
        
        return features;
    }
    
}
