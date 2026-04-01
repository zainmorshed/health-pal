package com.zain.health_pal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zain.health_pal.entity.PersonStats;
import com.zain.health_pal.service.StatSumService;

@RestController
@RequestMapping("/stats")
public class StatSumController {
    
    @Autowired
    private StatSumService statSumService;

    @PostMapping("/save")
    public String stats(@RequestBody PersonStats stats) {
        statSumService.savePersonStats(stats);

        return "Your stats have been saved!";
    }

    @GetMapping("/get-stats/{id}")
    public PersonStats getPersonStats(@PathVariable Long id){ 
        return statSumService.getPersonStats(id);

    }

    @GetMapping("/calculate-max-bpm/{id}")
    public String calculateMaxBpm(@PathVariable Long id) {
        int maxBpm = statSumService.calculateMaxBpm(id);

        return "Your maximum heart rate is: " + maxBpm + " bpm";
    }

    @GetMapping("calculate-vo2-max/{id}")
    public String calculateVO2Max(@PathVariable Long id) {

        double vo2Max = statSumService.calculateVO2Max(id);
        // int vo2MaxCast = (int) Math.round(vo2Max);

        if (vo2Max > 60) {
            return "Your VO2 Max is " + vo2Max + " mL/(kg*min). Your vo2 max comparable to elite athletes (60-70 ml/kg/min)";
        } else if (vo2Max > 25.0 && vo2Max < 45.0){
            return "Your VO2 Max is " + vo2Max + " mL/(kg*min). your vo2 max is average.";
        } else {
            return "Your VO2 Max is " + vo2Max + " mL/(kg*min). your vo2 max is below average!";
        }



    }
    


}
