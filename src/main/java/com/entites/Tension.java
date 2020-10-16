package com.entites;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tension {
    @Id
    private Long id;
    private double t_montante;
    private double t_descendante;
}
