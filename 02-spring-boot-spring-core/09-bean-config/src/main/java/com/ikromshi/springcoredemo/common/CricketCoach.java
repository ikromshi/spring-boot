package com.ikromshi.springcoredemo.common;

import org.springframework.stereotype.Component;


@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass());
        System.out.println("CricketCoach.class: " + CricketCoach.class.getMethods()[0]);
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }   
}
