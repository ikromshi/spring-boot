package com.ikromshi.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("In constructor: " + getClass());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
    
}
