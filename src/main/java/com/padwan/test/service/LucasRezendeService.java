package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LucasRezendeService {

    public List<String> skills() {
        List<String> skills = new ArrayList<>();

        skills.add("PHP");
        skills.add("Laravel Framework");
        skills.add("HTML");
        skills.add("CSS");
        skills.add("JS");
        skills.add("ReactJS");
        skills.add("Angular2");
        skills.add("JAVA");
        skills.add("Spring Framework");
        skills.add("SQL");
        skills.add("PostgreSQL");
        skills.add("Oracle DB");
        skills.add("MySQL");
        skills.add("MariaDB");
        skills.add("Hibernate ORM");
        skills.add("Flutter - In Process...");

        return skills;
    }

}
