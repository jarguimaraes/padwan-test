package com.padwan.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GuilhermeService {

	public List<String> skills(){

        List<String> skills = new ArrayList<>();
        skills.add("Goleiro");
        skills.add("Jogo - New World e CSGO");
        skills.add("Dev Java, Angular e brinco com algumas coisas de flutter");
        skills.add("SQL");
        skills.add("Analista SAP PI/PO e Data Service");
        skills.add("Colorado");
        return skills;

    }
}
