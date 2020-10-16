package com.entites;

import javax.persistence.*;

@Entity
public class ReleveInformations {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int trancheHoraireDebut;

    private int trancheHoraireFin;

    @OneToOne
    private Tension tension;

    @OneToOne
    private Repas repas;

    private String remarque;

}
