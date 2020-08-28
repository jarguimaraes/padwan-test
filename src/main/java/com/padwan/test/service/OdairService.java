package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OdairService {

    public List<String> skills(){
        List<String> skills = new ArrayList<>();
        List<String> skillsPersonal = new ArrayList<>();

        skills.add("Nome: Odair Xavier da Silva");
        skills.add("Idade: 33 anos");
        skills.add("E-mail: odair-o@hotmail.com");
        skills.add("Contato: (62) 9 9113-3369");

        skillsPersonal.add("force persistente");
        skillsPersonal.add("force criativo");
        skillsPersonal.add("force responsável");
        skillsPersonal.add("force paciente");
        skillsPersonal.add("force honesto");
        skillsPersonal.add("force humilde");
        skillsPersonal.add("force vontade de aprender");

        skills.add("Pessoais: " + skillsPersonal);

        return skills;
    }

}
