package com.zain.health_pal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zain.health_pal.entity.PersonStats;


@Repository
public interface StatRepository extends JpaRepository<PersonStats, Long>{

    
} 
    
