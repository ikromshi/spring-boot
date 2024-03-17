package com.ikromshi.springboot.demo.app.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    
    // inject properties for: coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose a new endpoint for "teamInfo"
    @GetMapping("/teamInfo")
    public String teamInfo() {
        return "Coach Name: " + coachName + ". Team Name: " + teamName;
    }


    // expose a "/" endpoint that returns a "Hello World."
    @GetMapping
    public String sayHello() {
        return "Hello bitches";
    }


    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5K";
    }


    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day";
    }
}
