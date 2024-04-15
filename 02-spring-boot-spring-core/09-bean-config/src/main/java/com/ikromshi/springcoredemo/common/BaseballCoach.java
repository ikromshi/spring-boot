package com.ikromshi.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("In constructor: " + getClass());
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes batting";
    }
}
