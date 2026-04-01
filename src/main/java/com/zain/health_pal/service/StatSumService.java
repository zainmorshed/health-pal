package com.zain.health_pal.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zain.health_pal.entity.PersonStats;
import com.zain.health_pal.exception.ResourceNotFoundException;
import com.zain.health_pal.repository.StatRepository;

@Service
public class StatSumService {
    
    @Autowired
    private StatRepository statRepository;

    private static final Logger logger = Logger.getLogger(StatSumService.class.getName());

    public PersonStats savePersonStats(PersonStats personStats){
        return statRepository.save(personStats);
    }
    

    public PersonStats getPersonStats(Long id) {
        logger.info("Fetching person stats for: " + id);
        return statRepository.findById(id)
                // .orElseThrow(() -> new RuntimeException("ID was not found"));
                // .orElseThrow(() -> {
                //     logger.warning("PersonStats not found with ID" + id);
                //     return new RuntimeException("ID was not found");
                // });
                .orElseThrow(() -> new ResourceNotFoundException("PersonStats not found for ID: " + id));
    }

    public int calculateMaxBpm(Long id) {
        PersonStats stats = statRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID not found"));

        int maxBpm = 220 - stats.getAge();
        return maxBpm;
    }

    
}
