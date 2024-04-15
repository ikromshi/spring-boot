package com.ikromshi.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    // define a  private field for the dependency;
    private Coach myCoach;

    // create a constructor in the class for dependency injection
    @Autowired
    public Controller(Coach theCoach) {
        this.myCoach = theCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();
    }
}
