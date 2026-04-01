package com.zain.health_pal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zain.health_pal.entity.PersonStats;

public interface StatRepository extends JpaRepository<PersonStats, Long>{

    
} 
    
