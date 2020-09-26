package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoaoCarlosService {

    public List<String> skills(){
        List<String> skills = new ArrayList<>();
        skills.add("programar");
        skills.add("jogar lol");
        skills.add("jogar overwatch");
        skills.add("cozinhar");
        skills.add("dirigir");
        skills.add("faxinar");
        return skills;
    }

}
