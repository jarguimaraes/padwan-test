package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FelipeService {

    public List<String> skills(){

        List<String> skills = new ArrayList<>();
        skills.add("Be Handsome");
        skills.add("Play - Guitar, Piano,");
        skills.add("Know a little of java");
        skills.add("Want to be better every day");
        skills.add("Big dreams");
        skills.add("Faith in God");
        return skills;

    }

}
