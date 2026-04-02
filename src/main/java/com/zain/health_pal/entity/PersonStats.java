package com.zain.health_pal.entity;

import com.zain.health_pal.enums.Activity;
import com.zain.health_pal.enums.Gender;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PersonStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private double height;
    private double weight;

    @Enumerated(EnumType.STRING)
    private Activity activityLevel;
    private int restingHeartRate;

    
    public PersonStats(Long personId, String name, int age, Gender gender, double height, double weight, Activity activityLevel, int restingHeartRate) {
        this.personId = personId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.activityLevel = activityLevel;
        this.restingHeartRate = restingHeartRate;
    }

    public PersonStats(){}

    public int getRestingHeartRate() {
        return restingHeartRate;
    }

    public void setRestingHeartRate(int restingHeartRate) {
        this.restingHeartRate = restingHeartRate;
    }



    public Long getPersonId() {
        return personId;
    }


    public void setPersonId(Long personId) {
        this.personId = personId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public Gender getGender() {
        return gender;
    }


    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public double getHeight() {
        return height;
    }


    public void setHeight(double height) {
        this.height = height;
    }


    public double getWeight() {
        return weight;
    }


    public void setWeight(double weight) {
        this.weight = weight;
    }


    public Activity getActivityLevel() {
        return activityLevel;
    }


    public void setActivityLevel(Activity activityLevel) {
        this.activityLevel = activityLevel;
    }

}
