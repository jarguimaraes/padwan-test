package com.padwan.test.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ValeriaGouveiaService {

	
	
    public List<String> skills(){
        List<String> skills = new ArrayList<>();
        skills.add("Conversar Sozinha..nesses dias essa habilidade valiosa");
        skills.add("Otimismo");
        skills.add("Multitarefa");
        skills.add("Persistencia..como sou persistente");
        skills.add("Pratica");
        return skills;
    }
}
