package com.entites;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Accessors(chain = true)
@Data
public class ApportNutritionnel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double potassium;
    private double sodium;
    private double calcium;
    private double magnesium;
    private double phosphore;

}
