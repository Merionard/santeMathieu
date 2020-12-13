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
public class Tension {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double t_montante;
    private double t_descendante;
}
