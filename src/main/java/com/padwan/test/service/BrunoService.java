package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrunoService {

	public List<String> skills(){
        
        List<String> dados = new ArrayList<>();
        List<String> skillsPessoal = new ArrayList<>();
        List<String> skillsTecnicas = new ArrayList<>();
        

        dados.add("Nome: Bruno Henrique Santos Araujo");
        dados.add("Idade: 21 anos");
        dados.add("E-mail: brunohenrique2208sb@gmail.com");
        dados.add("Contato: (62) 9 8534-3431");
        dados.add("Github: Bruno-Henrique-BR");

        skillsPessoal.add("Persistente");
        skillsPessoal.add("Esforçado");
        skillsPessoal.add("Dedicado");
        skillsPessoal.add("Honesto");
        skillsPessoal.add("Atencioso");
        skillsPessoal.add("Perfeccionista");
   
        
        skillsTecnicas.add("Java");
        skillsTecnicas.add("JavaScript");
        skillsTecnicas.add("HTML");
        skillsTecnicas.add("CSS");
        skillsTecnicas.add("C/C++");
        skillsTecnicas.add("PostgreSQL");
    

        dados.add("Pessoais: " + skillsPessoal);
        dados.add("Técnicas: " + skillsTecnicas);

        return dados;
    }

}
