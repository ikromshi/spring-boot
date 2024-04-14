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
    private Coach anotherCoach;

    // create a constructor in the class for dependency injection
    @Autowired
    public Controller(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach) {

        System.out.println("In constructor: " + getClass());
        this.myCoach = theCoach;
        this.anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();
    }

    // check the reference of the two coaches
    @GetMapping("/check")
    public String check() {
        return "Comparing beans myCoach == anotherCoach: " + (myCoach == anotherCoach);
    }
}
