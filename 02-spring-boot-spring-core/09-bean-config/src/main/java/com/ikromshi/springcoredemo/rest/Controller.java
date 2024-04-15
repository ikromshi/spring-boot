package com.ikromshi.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikromshi.springcoredemo.common.Coach;

@RestController
public class Controller {
    // define a  private field for the dependency;
    private Coach myCoach;

    // create a constructor in the class for dependency injection
    @Autowired
    public Controller(
            @Qualifier("aquatic") Coach theCoach) {

        System.out.println("In constructor: " + getClass());
        this.myCoach = theCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();
    }
}
