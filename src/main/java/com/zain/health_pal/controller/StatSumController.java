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
    


}
