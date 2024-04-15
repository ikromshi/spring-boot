package com.ikromshi.springcoredemo.common;

public class SwimCoach implements Coach {
    
    public SwimCoach() {
        System.out.println("In constructor: " + getClass());
    }

    @Override
    public String getDailyWorkout() {
        return "swom a 100 meters as a warmup";
    }
}
